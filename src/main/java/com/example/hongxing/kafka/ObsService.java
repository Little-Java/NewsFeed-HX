package com.example.hongxing.kafka;

import com.alibaba.fastjson.JSONObject;
import com.example.hongxing.common.Result;
import com.example.hongxing.config.ObsConfig;
import com.example.hongxing.dto.ArticleDto;
import com.obs.services.ObsClient;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
@Component
public class ObsService {

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif","image/png");
    private final Logger log = LoggerFactory.getLogger(getClass());

    private ObsConfig obsConfig;
    private static ObsClient obsClient;

    /* --------------------------  华为测试地址配置  -------------------------- */
//    private String objectEndpoint = "obs.cn-east-3.myhuaweicloud.com";
//    private String objectBucket = "newsfeed";
//    private String objectAk = "GFPROBWPYWHC481R8JRA";
//    private String objectSk = "1J0bsgo3BfmoCWlEYImR3S6FHIy4QAu34j8UD2U6";
//    private String specifiedPath = "D://QLDownload/images/aaa/111.JPG";

    /* --------------------------  华为内网地址配置  -------------------------- */
    private String objectEndpoint = "obs.jx-region-1.sgic.sgcc.com.cn";
    private String objectBucket = "kchx-yfzx-obs";
    private String objectAk = "TE9QX52F6BVGZDMSV5IX";
    private String objectSk = "kQLlFK6l6Af40zzFwsSod6xl4usCOe7qM5mePGxj";
    private String specifiedPath = "H://powersite/";

    
    public ObsConfig getObsHander() {
        if(obsConfig == null) {
            obsConfig = new ObsConfig(objectAk,objectSk,objectEndpoint);
            // 如果设置过CDN的路径测设置为CDN路径，没有设置则为桶原生的访问路径
            //obsHandler.setUrlForCDN(Global.get("ATTACHMENT_FILE_URL"));
            // 在数据库中读取进行操作的桶的明恒
            obsConfig.setObjectBucket(objectBucket);
            // 对桶名称进行当前类内缓存
            objectBucket = obsConfig.getObjectBucket();
        }
        return obsConfig;
    }

    /**
     * 获取华为云提供的操作客户端实体类
     * @return
     */
    public ObsClient getObsClient() {
        if(obsClient == null) {
            obsClient = new ObsClient(objectAk,objectSk,objectEndpoint);
        }
        return obsClient;
    }

    /**
     * 增量录音文件上传OBS
     */
    @Async
    public void excute(ArticleDto articleDto){
//        File file = new File(specifiedPath);
//        if(file.isFile() && file.getName().endsWith(".JPG")){
        File file = new File(specifiedPath + articleDto.getAcPicture().substring(3, articleDto.getAcPicture().length()));
        if(file.isFile()){
            int index = file.getAbsolutePath().indexOf("images");//articleDto.getAcAttachName()    QLDownload  /upload/200909
            String fileName = file.getAbsolutePath().substring(index).replaceAll("\\\\", "/");
            try{
                getObsHander().putLocalFile(objectBucket, fileName, file);
                getObsHander().setObjectAclPubilcRead(fileName);
                String url =  getObsHander().signatureUrl(fileName);
                System.out.println("上传完成：" + fileName);
                log.info(url);
            }catch (Exception e){
                log.error("上传{}失败:{}",fileName,e);
            }finally {
                //getObsHander().closeOBSClient();
            }
        }else{
            System.out.println("文件不存在:" + file.getAbsolutePath());
        }
    }

    /**
     * 下载ObsObject
     * @param bucketName    操作的桶的名称 例："kchx-yfzx-obs"
     * @param filePath   需要下载的文件路径。 例："D://QLDownload/images/aaa/111.JPG"
     * @return  下载文件的字节数组
     * @throws IOException
     */




    public byte[] getFileByteArray(String bucketName, String filePath) throws IOException {
        ObsObject obsObject = getObsClient().getObject(bucketName, filePath);
        InputStream input = null;
        byte[] b = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len;
        while ((len = input.read(b)) != -1){
            bos.write(b, 0, len);
        }
        bos.close();
        input.close();
        return bos.toByteArray();
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    public Result upload(MultipartFile file)
    {
        String contype = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        String sub = originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
        if(!CONTENT_TYPES.contains(contype)){
            log.info("文件类型出错"+originalFilename);
            return null;
        }try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null) {
                log.info("文件内容不合法" + originalFilename);
                return null;
            }
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("获取文件流失败");
        }
        //上传图片
        InputStream in=null;
        ObsClient obsClient = null;
        try{
            //获取图片名称，作为上传文件名参数
            String objectKey = file.getOriginalFilename();
            //获取流对象
            in= file.getInputStream();
            // 创建ObsClient实例
            obsClient = new ObsClient(obsConfig.getObjectAk(), obsConfig.getObjectSk(), obsConfig.getObjectEndpoint());
            // 使用访问OBS
            PutObjectResult putObjectResult = obsClient.putObject(obsConfig.getObjectBucket() , objectKey, in);
            //将图片信息封装起来，方便前端回显调用
            String url = putObjectResult.getObjectUrl();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", objectKey);
            jsonObject.put("url", url);
            return new Result( 500,"文件上传成功!", jsonObject);
        }catch (IOException e) {
            e.printStackTrace();
            System.err.println("上传图片失败!");
        } finally {
            try{
                if(in!=null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                System.err.println("输出流关闭失败！");
            }try{
                if(obsClient!=null){
                    // 关闭obsClient
                    obsClient.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                System.err.println("obs客户端流对象关闭失败！");
            }

        }
        return null;
    }

    //文件下载
//    public

    public static void main(String[] args) {
        String a = "../aaabbb";
        String b = a.substring(3, a.length());
        System.out.println(b);

        File file = new File("D:/QLDownload/images/aaa/111.JPG");
        System.out.println(file.isFile());
        int index = file.getAbsolutePath().indexOf("images");//articleDto.getAcAttachName()    QLDownload  /upload/200909
        System.out.println(index);
        String fileName = file.getAbsolutePath().substring(index).replaceAll("\\\\", "/");
        System.out.println(fileName);
    }
}

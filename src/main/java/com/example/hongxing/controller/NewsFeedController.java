package com.example.hongxing.controller;

import com.example.hongxing.common.Result;
import com.example.hongxing.utils.ImagGetUrlUtil;
import com.example.hongxing.config.ObsConfig;
import com.example.hongxing.dto.ArticleDto;
import com.example.hongxing.dto.KafkaDto;
import com.example.hongxing.kafka.KafkaProducer;
import com.example.hongxing.kafka.ObsService;
import com.example.hongxing.service.ArticleService;
import com.obs.services.ObsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/kafka")
public class NewsFeedController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ObsService obsService;

//    private String specifiedPath = "H://powersite/";
    private String specifiedPath = "D://";

    /**
     * 推送文章
     * @param acId
     * @return
     */
    @RequestMapping("/addMessage")
    @ResponseBody
    public Result addMessage(Integer acId){
        if(acId == null){
            return new Result(200, "请求成功", "文章ID不能为空");
        }
        ArticleDto articleDto = articleService.getArticleById(acId);
        if(articleDto == null){
            return new Result(200, "请求成功", "文章不存在");
        }

        KafkaDto kafkaDto = new KafkaDto();
        kafkaDto.setArticleDto(articleDto);
        if(articleDto.getAcText()!=null && articleDto.getAcText() !=""){

            List<String> list = ImagGetUrlUtil.getImgSrc(articleDto.getAcText());
            List<String> urlList = new ArrayList<>();
            if(list !=null && list.size()>0) {
                for (String url : list) {
                    if(url.substring(0,3).equals("../")){
                        File file = new File(specifiedPath + url.substring(3, url.length()));
                        if (file.isFile()) {
                            int index = file.getAbsolutePath().indexOf("images");//articleDto.getAcAttachName()    QLDownload  /upload/200909
                            String fileName = file.getAbsolutePath().substring(index).replaceAll("\\\\", "/");
                            urlList.add(fileName);
                        }
                    }else if(url.substring(0,3).equals("fil")){
                        File files = new File(url.substring(8, url.length()));
                        if (files.isFile()) {
                            int index = files.getAbsolutePath().indexOf("images");//articleDto.getAcAttachName()    QLDownload  /upload/200909
                            String fileName = files.getAbsolutePath().substring(index).replaceAll("\\\\", "/");
                            urlList.add(fileName);
                        }
                    }
                }
                kafkaDto.setObsUrl(urlList);

            }
            // 任务存入到kafka消息队列中
            kafkaProducer.addMessage(kafkaDto);
            obsService.excute(articleDto);
        }else {
            // 任务存入到kafka消息队列中
            kafkaProducer.addMessage(kafkaDto);
        }

        return new Result(200, "发送成功",kafkaDto);
    }

    /**
     * 测试obs上传是否正常
     * @return
     */
    @RequestMapping(value="/testUploadObs")
    @ResponseBody
    public Result test(){
        ArticleDto articleDto = new ArticleDto();
        articleDto = articleService.getArticleById(2361927);
        obsService.excute(articleDto);
        return new Result(500, "请求成功");
    }

    /**
     * 测试obs是否存在
     * @return
     */
    @RequestMapping(value="/testObs")
    @ResponseBody
    public Result testObs(){
        ObsConfig params = new ObsConfig();
        try {
            String endPoint = params.getObjectEndpoint();
            String ak = params.getObjectAk();
            String sk = params.getObjectSk();
            String bucket = params.getObjectBucket();

            // 创建ObsClient实例
            ObsClient obsClient = new ObsClient(ak, sk, endPoint);
            if(obsClient == null){
                return new Result(200, "请求成功", "创建obs失败");
            }

            // 测试bucket是否存在OBS
            boolean bValue   = obsClient.headBucket(bucket);

            // 关闭obsClient
            obsClient.close();
            return new Result(200, "请求成功", bValue == true ?"obs桶存在":"obs桶不存在");

        }catch (Exception e){
            e.printStackTrace();
            return  new Result(200, "请求成功", "异常");
        }
    }

    @RequestMapping(value="/testGetUrl")
    @ResponseBody
    public Result testGetUrl(){
        ArticleDto articleDto = new ArticleDto();
        articleDto = articleService.getArticleById(2361934);
        List<String> list = ImagGetUrlUtil.getImgSrc(articleDto.getAcText());
        return new Result(500, "请求成功", list);
    }
}

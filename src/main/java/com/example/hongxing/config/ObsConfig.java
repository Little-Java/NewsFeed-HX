package com.example.hongxing.config;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ObsConfig {

    /* --------------------------  华为测试地址配置  -------------------------- */
//    private String objectEndpoint = "obs.cn-east-3.myhuaweicloud.com";
//    private String objectBucket = "newsfeed";
//    private String objectAk = "GFPROBWPYWHC481R8JRA";
//    private String objectSk = "1J0bsgo3BfmoCWlEYImR3S6FHIy4QAu34j8UD2U6";

    /* --------------------------  华为内网地址配置  -------------------------- */
    private String objectEndpoint = "obs.jx-region-1.sgic.sgcc.com.cn";
    private String objectBucket = "kchx-yfzx-obs";
    private String objectAk = "TE9QX52F6BVGZDMSV5IX";
    private String objectSk = "kQLlFK6l6Af40zzFwsSod6xl4usCOe7qM5mePGxj";

    private String url; // 访问OBS文件的url

    private static ObsClient obsClient;

    public ObsConfig() {

    }

    /**
     * 获取华为云提供的操作客户端实体类
     * @return
     */
    public ObsClient getObsClient() {
        if(obsClient == null) {
            obsClient = new ObsClient(objectAk, objectSk, objectEndpoint);
        }
        return obsClient;
    }

    /**
     * 创建华为云OBS的本地控制器
     * @param accessKeyId
     * @param accessKeySecret
     * @param endpoint
     */
    public ObsConfig(String accessKeyId, String accessKeySecret, String endpoint) {
        this.objectAk = accessKeyId;
        this.objectSk = accessKeySecret;
        this.objectEndpoint = endpoint;
    }

    public ObsConfig(String accessKeyId, String accessKeySecret, String endpoint, String obsBucketName) {
        this.objectAk = accessKeyId;
        this.objectSk = accessKeySecret;
        this.objectEndpoint = endpoint;
        this.objectBucket = obsBucketName;
    }

    /**
     * 设置OBS访问的CDN路径
     * @param url
     */
    public void setUrlForCDN(String url) {
        this.url = url;
    }

    /**
     * 设置OBS操作的同桶名称
     * @param obsBucketName
     */
    public void setObsBucketName(String obsBucketName) {
        this.objectBucket = obsBucketName;
    }

    /**
     * 为对象设置公共读
     * @param objectKey
     */
    public HeaderResponse setObjectAclPubilcRead(String objectKey){
        return  obsClient.setObjectAcl(objectBucket, objectKey, AccessControlList.REST_CANNED_PUBLIC_READ);
    }

    /**
     *  获得下载路径
     * @param objectKey
     * @return
     */
    public String signatureUrl(String objectKey){
        long expireSeconds = 3600L;
        Map<String, String> headers = new HashMap<String, String>();

        String contentType = "text/plain";
        headers.put("Content-Type", contentType);

        TemporarySignatureRequest request = new TemporarySignatureRequest(HttpMethodEnum.PUT, expireSeconds);
        request.setBucketName(objectBucket);
        request.setObjectKey(objectKey);
        request.setHeaders(headers);

        TemporarySignatureResponse response = obsClient.createTemporarySignature(request);

        return response.getSignedUrl();
    }

    /**
     * 通过流上传字符串为文件
     * @param bucketName  操作的桶的名称 例："newsfeed "
     * @param fileName  上传的路径和文件名 例："site/2010/example.txt"
     * @param content  上传的String字符
     * @param encode  进行转换byte时使用的编码格式 例："UTF-8"
     * @return
     * @throws ObsException
     * @throws UnsupportedEncodingException
     */
    public PutObjectResult putStringFile(String bucketName, String fileName, String content, String encode) throws ObsException, UnsupportedEncodingException {
        return getObsClient().putObject(bucketName, fileName, new ByteArrayInputStream(content.getBytes(encode)));
    }

    /**
     * 上传文件本地文件
     * @param bucketName 操作的桶的名称 例："newsfeed"
     * @param fileName  上传的路径和文件名 例："site/2010/example.txt"
     * @param localFile  需要上传的文件
     * @return
     */
    public PutObjectResult putLocalFile(String bucketName, String fileName, File localFile) {
        return getObsClient().putObject(bucketName, fileName, localFile);
    }


    public String getObjectEndpoint() {
        return objectEndpoint;
    }

    public void setObjectEndpoint(String objectEndpoint) {
        this.objectEndpoint = objectEndpoint;
    }

    public String getObjectBucket() {
        return objectBucket;
    }

    public void setObjectBucket(String objectBucket) {
        this.objectBucket = objectBucket;
    }

    public String getObjectAk() {
        return objectAk;
    }

    public void setObjectAk(String objectAk) {
        this.objectAk = objectAk;
    }

    public String getObjectSk() {
        return objectSk;
    }

    public void setObjectSk(String objectSk) {
        this.objectSk = objectSk;
    }

    public static void setObsClient(ObsClient obsClient) {
        ObsConfig.obsClient = obsClient;
    }
}

package com.shanjupay.merchant.service;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.common.domain.CommonErrorCode;
import com.shanjupay.common.util.AliyunUtil;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service  //实例为一个bean
public class FileServiceImpl implements FileService{

    @Value("${oss.aliyun.endpoint}")
    private String endpoint;

    @Value("${oss.aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.aliyun.bucketName}")
    private String bucketName;

    @Value("${oss.aliyun.url}")
    private String aliyunUrl;

    /**
     * 上传资质文件
     * */
    @Override
    public String upload(byte[] bytes, String fileName) throws BusinessException {

        try {
            //调用工具类AliyunUtil上传
            AliyunUtil.upload(endpoint, accessKeyId, accessKeySecret, bucketName, bytes, "intelligence/" + fileName);
        } catch (RuntimeException e)
        {
            e.printStackTrace();
            throw new BusinessException(CommonErrorCode.E_100106);
        }
        return aliyunUrl + fileName;
    }
}

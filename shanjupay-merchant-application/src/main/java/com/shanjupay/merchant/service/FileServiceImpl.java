package com.shanjupay.merchant.service;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.common.domain.CommonErrorCode;
import com.shanjupay.common.util.AliyunUtil;
import com.shanjupay.common.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;

@org.springframework.stereotype.Service  //实例为一个bean
public class FileServiceImpl implements FileService{

    private String accessKeyId="1Ekf6UPFOzZFLd7WdI2SfISG3D-mbgSxpuphuCPW";

    private String accessKeySecret = "KIfSSrQvdhQmVN8Ml0nL1hwqLlnAY6uj1BrdF_Qe";

    private String bucketName = "ldhshanjupay";

    private String domainOfBucket = "http://rl6e97x37.hn-bkt.clouddn.com";

    /**
     * 上传资质文件
     * */
    @Override
    public String upload(byte[] bytes, String fileName) throws BusinessException {

        try {
            //调用工具类AliyunUtil上传
            fileName = "tt-"+fileName;
            QiniuUtils.upload2qiniu( accessKeyId, accessKeySecret, bucketName, bytes, fileName);
        } catch (RuntimeException e)
        {
            e.printStackTrace();
            throw new BusinessException(CommonErrorCode.E_100106);
        }
        return fileName;
    }

    @Override
    public String getDownUrl(String fileName) throws BusinessException, UnsupportedEncodingException {
        return QiniuUtils.getdownloadurl(fileName,domainOfBucket,accessKeyId,accessKeySecret);
    }

}

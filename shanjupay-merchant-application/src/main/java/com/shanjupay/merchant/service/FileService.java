package com.shanjupay.merchant.service;

import com.shanjupay.common.domain.BusinessException;

import java.io.UnsupportedEncodingException;

/**
 * @author Administrator
 * @version 1.0
 **/
public interface FileService {

    /**
     *  上传文件
     * @param bytes 文件字节数组
     * @param fileName 文件名
     * @return  文件访问路径（绝对的url）
     * @throws BusinessException
     */
    public String upload(byte[] bytes,String fileName) throws BusinessException;

    public String getDownUrl(String fileName) throws BusinessException, UnsupportedEncodingException;
}

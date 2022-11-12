package com.shanjupay.transaction.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 支付宝接口对接测试类
 * @author Administrator
 * @version 1.0
 **/

@Slf4j
@Controller //json格式+html格式
//@RestController//请求方法响应统一json格式
public class PayTestController {

    //应用id
    String APP_ID = "2021000121688254";
    //应用私钥
    String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC92Xt3AmB7KQFb+jI5Tc8WlUU9E7sl4OJBLLqpFbafdWWFIp7nhDw5PqCJOdQsW/CYDq4TyAziRZKpHXstxZIZMnIpHi4y6jo5cLCV4r6b0mYrvtI4sbYsux8yvna7Qcp8/VBr5Lh10i2pJpAKHZif7ezT1jkvF0AHweOhx0KvlNL84JVIC+P0gUZ62pRYsaL1QubDX3VjRKmxPpnFF2LcD+CO/cxWTHw7mj/rNdIIYM+O2cnF7/K5t0jINtFL3U0D7Q9P40hLxhpGWbcOwuuowkCOX5jE26ByHmnIR141r/MZKq4XdzYP3Bscm0RsgLtVdKamgXyDCtwCkCFYvdkVAgMBAAECggEBAKEpiCfk+qZSjvbXk98VcGEJYneQ0mQ7XZZaNDLpXdhLvlygoSiEFuO5iGo1jyoA+mL6w0fDoTxMN04c2r5mY7nEGylQl4NdVwP/58e1bn20xEsKeEbshWu/haJ8ESqxlQU5vRV6WiSawWxAcjJEIZZSUaMazfxtzktHiseA8dk+EQygoyBdWaX2+6/GCUuTcOQb4bB9uQ4dbp5MTd/sEggYf0PiYOV/uTRb9TVaDLCIp6JS/xhnG28hHrfpG8ok3faQnHNbgiy3be98JmQ1nc/yfoyXUQ09s1kgSK02E2wFfkvvmebuFQZJYLTMyShsU64pKSQtcg8zvQsKwV1kUhkCgYEA/sq3hDzqSt28GD1LRY0I0J9Aq6XsaK6ANQJKSFU5btqV3w9t6qRiCLHf9uuTgXIz64pvr5IMTu54NwhsaeKearsJ5mJaVO+vWxioYB3dI+8e3GCG1Cudxxeq9MlwlaXSxAKwqxbzH2Zwo5eeskgXMkmJTaWHB2RmBDo/kbwiaH8CgYEAvr/vJNy1huzkxrGoMBPj9T67Ev9XApoao3kFQDeU6Ls36a3dLur/zI7sCeDaeKm8GQ8RknYMdxD04nWbI4FtmQ8btSnVT2OEev09D2nhWB9Px5zRNGmc0kNheanpAv3MhA11SDl96dwgYloMN1b+jMfeUcX3SmMdfkCGeGat1GsCgYBcuxLHghQTY1gNymEW0xmeNBepYR4Fi10F7etzH/FjMxLQuCDdAS7c00Ab8ekhd5sF4sB7OcBZCdmezeYHM39MgP49ZxZRS1qa4QKG2NefOGwW8NqhZa5qw2Zo6Nec31kyFXiPDC84AmSEZa5QXIR0vObH57KZMiUe7MQuGja7qQKBgQCgqEulQndp4tB1QWCkzbvr7R/nSkRgnqbdFKsFgUrcEgNvv85RHADCq4XGdCnOAze362cjcmXhStjWe7Nk3jgO+BigJ1HQAcOtSulIuCbh781kFIJnoKRCvBm3PRJSQK0mc6daY4HXnF1yOOGdIppWvGhVe2Vis8Q9d99KPUEfbQKBgQDiSKSIqvRgQ2bwwmWeFfNn916srBBu1XnpCU/tJiZPlxqAJtkL5nONMAd8N5A4sLBuWpg+xMG+NGq2Vge7Jvh2X1A5FsDxGUAnygUoj3+RUyyvRcyLfYg58Ygcggywa/vvNipRf9Fi2EUvTip/q556PaJpweFp6GWeGDYJgdXd7Q==";
   //支付宝公钥
    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvdl7dwJgeykBW/oyOU3PFpVFPRO7JeDiQSy6qRW2n3VlhSKe54Q8OT6giTnULFvwmA6uE8gM4kWSqR17LcWSGTJyKR4uMuo6OXCwleK+m9JmK77SOLG2LLsfMr52u0HKfP1Qa+S4ddItqSaQCh2Yn+3s09Y5LxdAB8HjocdCr5TS/OCVSAvj9IFGetqUWLGi9ULmw191Y0SpsT6ZxRdi3A/gjv3MVkx8O5o/6zXSCGDPjtnJxe/yubdIyDbRS91NA+0PT+NIS8YaRlm3DsLrqMJAjl+YxNugch5pyEdeNa/zGSquF3c2D9wbHJtEbIC7VXSmpoF8gwrcApAhWL3ZFQIDAQAB";
    String CHARSET = "utf-8";
    //支付宝接口的网关地址，正式"https://openapi.alipay.com/gateway.do"
    String serverUrl = "https://openapi.alipaydev.com/gateway.do";
    //签名算法类型
    String sign_type = "RSA2";

    @GetMapping("/alipaytest")
    public void alipaytest(HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws ServletException, IOException {
        //构造sdk的客户端对象
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, sign_type); //获得初始化的AlipayClient
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
//        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
//        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"20150420010101017\"," +
                " \"total_amount\":\"88.88\"," +
                " \"subject\":\"Iphone6 16G\"," +
                " \"product_code\":\"QUICK_WAP_PAY\"" +
                " }");//填充业务参数
        String form="";
        try {
            //请求支付宝下单接口,发起http请求
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

}

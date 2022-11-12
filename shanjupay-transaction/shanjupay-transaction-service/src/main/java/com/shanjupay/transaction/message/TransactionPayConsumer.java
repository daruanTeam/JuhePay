package com.shanjupay.transaction.message;

import com.alibaba.fastjson.JSON;
import com.shanjupay.paymentagent.api.dto.PaymentResponseDTO;
import com.shanjupay.paymentagent.api.dto.TradeStatus;
import com.shanjupay.transaction.api.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 **/
//@Component
//@RocketMQMessageListener(topic = "TP_PAYMENT_RESULT",consumerGroup="CID_ORDER_CONSUMER")
@Slf4j
public class TransactionPayConsumer implements RocketMQListener<MessageExt> {

    @Autowired
    TransactionService transactionService;

    @Override
    public void onMessage(MessageExt messageExt) {
//
//        byte[] body = messageExt.getBody();
//        String jsonString = new String(body);
//        log.info("交易服务向接收到支付结果消息：{}", JSON.toJSONString(jsonString));
//        //接收到消息，内容包括订单状态
//        PaymentResponseDTO paymentResponseDTO = JSON.parseObject(jsonString, PaymentResponseDTO.class);
//        String tradeNo = paymentResponseDTO.getTradeNo();//支付宝微信的订单号订单号
//        String outTradeNo = paymentResponseDTO.getOutTradeNo();//闪聚平台的订单号
//        //订单状态
//        TradeStatus tradeState = paymentResponseDTO.getTradeState();
//        //更新数据库
//        switch (tradeState){
//            case SUCCESS:
//                //String tradeNo, String payChannelTradeNo, String state
//                //成功
//                transactionService.updateOrderTradeNoAndTradeState(outTradeNo,tradeNo,"2");
//                return ;
//            case REVOKED:
//                //关闭
//                transactionService.updateOrderTradeNoAndTradeState(outTradeNo,tradeNo,"4");
//                return ;
//            case FAILED:
//                //失败
//                transactionService.updateOrderTradeNoAndTradeState(outTradeNo,tradeNo,"5");
//                return ;
//             default:
//                 throw new RuntimeException(String.format("无法解析支付结果:%s",body));
//        }

    }
}

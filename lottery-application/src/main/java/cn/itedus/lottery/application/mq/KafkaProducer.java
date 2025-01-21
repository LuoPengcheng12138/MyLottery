package cn.itedus.lottery.application.mq;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;


import javax.annotation.Resource;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * @description:
 * @author：Luopc
 * @date: 2024/12/8
 */
@Component
public class KafkaProducer {
    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    public static final String TOPIC_TEST = "Hello-Kafka";
    public static final String TOPIC_GROUP = "test-consumer-group";

    public void send(Object obj) {
        String obj2String= JSON.toJSONString(obj);
        logger.info("准备发送消息为:{}",obj2String);
        ListenableFuture<SendResult<String,Object>> future=kafkaTemplate.send(TOPIC_TEST,obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String,Object>>() {
            @Override
            public void onSuccess(SendResult<String,Object> stringObjectSendResult) {
                logger.info(TOPIC_TEST + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
            @Override
            public void onFailure(Throwable throwable) {
                logger.info(TOPIC_TEST + " - 生产者 发送消息失败：" + throwable.getMessage());

            }
        });

    }


}



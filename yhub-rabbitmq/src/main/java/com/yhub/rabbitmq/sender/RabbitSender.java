package com.yhub.rabbitmq.sender;

import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description 消息发送者
 * @date 2018/8/14
 */
@Service
public class RabbitSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试广播模式
     */
    public void broadcast(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", p, correlationData);
        logger.info("测试广播模式 ==== " + p);
    }

    /**
     * 测试Direct模式
     */
    public void direct(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY", p, correlationData);
        logger.info("测试Direct模式 ==== " + p);
    }
}

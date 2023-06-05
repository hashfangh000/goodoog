package com.example.goodoog.base.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * 发送同步消息
 */
public class SyncProducer {
    public static void main(String[] args) {
         // 1、创建消息生产producer 并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 2、指定Nameserver地址
        producer.setNamesrvAddr(" ");
    }
}

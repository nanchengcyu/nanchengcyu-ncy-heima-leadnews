package cn.nanchengyu.xxljob.sample;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * ClassName: ConssumerQuickStart
 * Package: cn.nanchengyu.kafka.sample
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/31 22:50
 * @Version 1.0
 */
public class ConsumerQuickStart {
    public static void main(String[] args) {
        //1. kafka的配置信息
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"xxxx:9092");
        //KV反序列化操作 对其他类型转化为Java对象
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");

        //设置消费组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"group1");


        //2. 创建消费者对象
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<>(properties);

        //3. 订阅主题  -- 多个组 接手 一对多
        kafkaConsumer.subscribe(Collections.singletonList("topic-first"));

        //4. 拉取消息
        while (true){
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key());
                System.out.println(consumerRecord.value());
                System.out.println("-----------");
                System.out.println(consumerRecord.key()+"--->"+consumerRecord.value());
            }
        }


    }
}

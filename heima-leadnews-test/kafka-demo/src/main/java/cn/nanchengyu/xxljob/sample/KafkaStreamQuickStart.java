package cn.nanchengyu.xxljob.sample;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.ValueMapper;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * ClassName: KafkaStreamQuickStart
 * Package: cn.nanchengyu.xxljob.sample
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/2 23:52
 * @Version 1.0
 */
public class KafkaStreamQuickStart {
    public static void main(String[] args) {
        //kafka的核心配置
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.11668.200.130:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-quickstart");


        //stream构建器
        StreamsBuilder streamsBuilder = new StreamsBuilder();//流式计算
        streamProcess(streamsBuilder);

        //创建KafkaStream对象
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), properties);

        //开启流式计算
        kafkaStreams.start();
    }

    /**
     * 流式计算
     *
     * @param streamsBuilder
     */
    private static void streamProcess(StreamsBuilder streamsBuilder) {
        //创建kstream对象，同时指定从那个topic中接收消息
        KStream<String, String> stream = streamsBuilder.stream("itcast-topic-input");

        /**
         * 处理消息的value
         */
        stream.flatMapValues(new ValueMapper<String, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(String value) {
                        //消息分割 并返回一个字符串
                        return Arrays.asList(value.split(""));
                    }
                })
                //按照value进行信息聚合处理
                .groupBy((key, value) -> value)
                .windowedBy(TimeWindows.of(Duration.ofSeconds(10)))
                .count() //统计单词个数
                .toStream()
                .map((key, value) ->
                        new KeyValue<>(key.toString(), value.toString())
                )
                .to("itcast-topic-input"); //发送消息


    }
}

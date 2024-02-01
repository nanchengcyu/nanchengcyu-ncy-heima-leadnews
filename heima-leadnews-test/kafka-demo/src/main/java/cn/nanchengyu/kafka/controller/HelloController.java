package cn.nanchengyu.kafka.controller;

import cn.nanchengyu.kafka.pojo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * ClassName: HelloController
 * Package: cn.nanchengyu.kafka.controller
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/1 17:47
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Resource
    private User user;

    @GetMapping("/hello")
    public String hello() {
//        kafkaTemplate.send("test-topic","nanchengyu");
        user.setName("nanchengyu");
        user.setAge(20);
        kafkaTemplate.send("topic-user", JSON.toJSONString(user)); //发送消息时转换为JSON 字符串
        return "OK";
    }


}

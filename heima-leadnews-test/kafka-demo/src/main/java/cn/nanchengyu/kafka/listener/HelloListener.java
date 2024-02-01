package cn.nanchengyu.kafka.listener;

import cn.nanchengyu.kafka.pojo.User;
import com.alibaba.fastjson.JSON;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * ClassName: HelloListener
 * Package: cn.nanchengyu.kafka.listener
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/1 17:54
 * @Version 1.0
 */
@Component
public class HelloListener {
  @KafkaListener(topics="test-topic")
  public void onMessage(String message){
    if (!StringUtils.isEmpty(message)){
      User user = JSON.parseObject(message, User.class); //收消息转换为对象
      System.out.println(message);
      System.out.println(user);

    }
  }
}

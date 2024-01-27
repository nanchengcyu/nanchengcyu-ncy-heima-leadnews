package cn.nanchengyu.freemarker;

import cn.nanchengyu.freemarker.entity.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * ClassName: test
 * Package: cn.nanchengyu.freemarker
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/27 23:36
 * @Version 1.0
 */
@SpringBootTest(classes = FreemarkerDemoApplication.class)
@RunWith(SpringRunner.class)
public class FreemarkerTest{

    @Autowired
    private Configuration configuration;

    @Test
    public void test() throws IOException, TemplateException {
        Template template = configuration.getTemplate("02-list.ftl");

        /*
        合成方法
        两个参数
        第一个参数为 模型数据
        第二个参数为 输出流
         */

    template.process(getData(),new FileWriter("D:/Afile/studynote/heima-leadnews/list.html"));

    }
    private Map getData(){
        HashMap<String, Object> map = new HashMap<>();
        //------------------------------------
        Student stu1 = new Student();
        stu1.setName("小强");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());

        //小红对象模型数据
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);

        //将两个对象模型数据存放到List集合中
        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        //向model中存放List集合数据
        map.put("stus",stus);

        //map数据
        Map<String,Student> stuMap = new HashMap<>();
        stuMap.put("stu1",stu1);
        stuMap.put("stu2",stu2);

        map.put("stuMap",stuMap);
        map.put("today",new Date());
        //日期


        //长数值
        map.put("point",38473897438743L);


        return map;
    }


}
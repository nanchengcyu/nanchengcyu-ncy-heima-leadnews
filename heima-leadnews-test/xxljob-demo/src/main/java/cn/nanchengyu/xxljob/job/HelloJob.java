package cn.nanchengyu.xxljob.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: HelloJob
 * Package: cn.nanchengyu.xxljob.job
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/2 18:27
 * @Version 1.0
 */
@Component
public class HelloJob {
    @XxlJob("demoJobHandler")
    public void helloJob() {
        System.out.println("简单任务执行了");
    }

    @XxlJob("shardingJobHandler")
    public void shardingJobHandler() {
        //分片参数
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();
        //业务逻辑
        List<Integer> list = getList();
        for (Integer integer : list) {
            if (integer % shardTotal == shardIndex) {
                System.out.println("当前第" + shardIndex + "分片执行了，任务项为" + integer);
            }
        }

    }

    public List<Integer> getList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        return list;
    }
}

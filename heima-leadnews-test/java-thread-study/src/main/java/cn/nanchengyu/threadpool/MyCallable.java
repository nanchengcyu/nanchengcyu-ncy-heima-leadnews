package cn.nanchengyu.threadpool;

import java.util.concurrent.Callable;

/**
 * ClassName: MyCallabl
 * Package: cn.nanchengyu.threadpool
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/4 11:37
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    //重写call方法
    @Override
    public String call() throws Exception {
        //描述 线程的任务 返回线程执行后的结果
        //需求 求1-n的和返回
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName()+"求出了1-" + n+ "的和是:" +sum;

    }
}

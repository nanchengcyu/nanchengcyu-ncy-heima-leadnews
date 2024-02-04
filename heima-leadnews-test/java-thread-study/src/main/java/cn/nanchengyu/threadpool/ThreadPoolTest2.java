package cn.nanchengyu.threadpool;

import java.util.concurrent.*;

/**
 * ClassName: Appliaction
 * Package: cn.nanchengyu.study
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/4 10:42
 * @Version 1.0
 */
public class ThreadPoolTest2 {
    public static void main(String[] args) throws Exception{
        //创建线程池
     /*   int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime, //存活时间
        TimeUnit unit,  //存活时间的单位 s m h
        BlockingQueue<Runnable> workQueue,
//        ThreadFactory threadFactory,
        RejectedExecutionHandler handler*/
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //创建MyCallable对象
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));
        //打印 获取对象
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());

    }
}

package cn.nanchengyu.threadpool;

import cn.nanchengyu.study.MyThread;
import org.apache.logging.log4j.core.util.ExecutorServices;

import javax.jnlp.ExtendedService;
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
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        //创建线程池
     /*   int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime, //存活时间
        TimeUnit unit,  //存活时间的单位 s m h
        BlockingQueue<Runnable> workQueue,
//        ThreadFactory threadFactory,
        RejectedExecutionHandler handler*/
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //创建MyRunnable对象
        Runnable target = new MyRunnable();
        pool.execute(target); //线程池自动创建线程
        pool.execute(target); //线程池自动创建线程
        pool.execute(target); //线程池自动创建线程
        pool.execute(target); //复用前面的核心线程
        pool.execute(target); //复用前面的核心线程
        /*
        pool.shutdown(); //等待线程任务执行完 关闭线程池
        pool.shutdownNow(); //线程是否执行完都会关闭线程，未执行完的则会抛出异常*/
    }
}

package cn.nanchengyu.threadpool;

/**
 * ClassName: MyRunnable
 * Package: cn.nanchengyu.threadpool
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/4 11:22
 * @Version 1.0
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"==> ncy 线程");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

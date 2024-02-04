package cn.nanchengyu.study;

/**
 * ClassName: Mythread
 * Package: cn.nanchengyu.study
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/4 10:43
 * @Version 1.0
 */
//1. 继承Thread类
public class MyThread extends Thread{
    @Override
    //2.重新Thread的run方法
    public void run() {
        for (int i = 1; i <=5 ; i++) {
            System.out.println("MyThread线程的输出"+i);
        }

    }
}

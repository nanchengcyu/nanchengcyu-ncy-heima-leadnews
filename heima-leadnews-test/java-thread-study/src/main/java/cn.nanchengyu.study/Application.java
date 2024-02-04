package cn.nanchengyu.study;

/**
 * ClassName: Appliaction
 * Package: cn.nanchengyu.study
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/4 10:42
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {
        //3.在main方法中创建MyThread类的对象  此时有两个线程 一个是main线程
        //一个是MyThread线程
        Thread myThread = new MyThread(); //多态写法
       //4. 需要调用start方法 启动run方法
        myThread.start();

        for (int i = 1; i <=5 ; i++) {
            System.out.println("主线程main的输出"+i);
        }
    }
}

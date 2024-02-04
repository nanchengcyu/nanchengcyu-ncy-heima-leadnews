package cn.nanchengyu.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: Demo
 * Package: cn.nanchengyu.threadpool
 * Description:
 * 送礼物
 *
 * @Author 南城余
 * @Create 2024/2/4 17:24
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> gift = new ArrayList<>();
        String[] names = {"mc口红", "包", "鲜花", "IWatch"};
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            gift.add(names[r.nextInt(names.length)] + (i + 1));
        }
//        System.out.println(gift);
        //定义线程类，创建线程对象
        SendThread xm = new SendThread(gift, "xm");
        xm.start();
        SendThread xh = new SendThread(gift, "xh");
        xh.start();
        xm.join();
        xh.join();

        System.out.println(xm.getCount());
        System.out.println(xh.getCount());
    }



}

class SendThread extends Thread {
    private List<String> gift;
    private int count;

    public SendThread(List<String> gift, String name) {
        super(name);
        this.gift = gift;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            //锁要保证唯一性
            synchronized (gift) {
                if (gift.size() < 10) {
                    break;
                }
                String removeGift = gift.remove(random.nextInt(gift.size()));

                System.out.println(Thread.currentThread().getName() + "发出去了几个礼物i" + removeGift);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

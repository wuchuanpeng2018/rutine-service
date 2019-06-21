package com.onecard;

import java.util.concurrent.*;

/**
 * @description: countdownlatch
 * CountDownLatch是一个同步辅助类，犹如倒计时计数器，
 * 创建对象时通过构造方法设置初始值，调用CountDownLatch对象的await()方法则处于等待状态，
 * 调用countDown()方法就将计数器减1，当计数到达0时，则所有等待者或单个等待者开始执行
 * 惊群效应 ???
 * @author: wuchu
 * @date: Created in 2019/6/20 21:32
 */
public class CountDownLatchTest {


    /**
     *  面试：如何模拟一个并发
     * @author: wuchu
     * @date: Created in 2019/6/20 21:55
     * @param null
     * @return
     */
    /**
     * 该程序用来模拟发送命令与执行命令，主线程代表指挥官，
     * 新建3个线程代表战士，战士一直等待着指挥官下达命令，
     * 若指挥官没有下达命令，则战士们都必须等待。一旦命令下达，
     * 战士们都去执行自己的任务，指挥官处于等待状态，战士们任务执行完毕则报告给
     * 指挥官，指挥官则结束等待。
     * @author: wuchu
     * @date: Created in 2019/6/20 21:53
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        final CountDownLatch adminX = new CountDownLatch(1);
        final CountDownLatch userX = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i=0;i<3;i++) {
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try{
                        System.out.println("线程" + Thread.currentThread().getName() + "开始整备接受任务");
                        adminX.await();
                        System.out.println("线程" + Thread.currentThread().getName() + "已接送命令");
                        Thread.sleep(1000);
                        System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        userX.countDown();
                    }
                }
            };
            service.execute(runnable);
        }
        try {
            Thread.sleep(1000);
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
            adminX.countDown();
            System.out.println("线程" + Thread.currentThread().getName() +"已发送命令，正在等待结果");
            userX.await();
            System.out.println("线程" + Thread.currentThread().getName() +"已收到所有响应结果");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        service.shutdown();
    }

}

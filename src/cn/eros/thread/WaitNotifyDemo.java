package cn.eros.thread;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * <p>Create time: 2020/6/1 23:36</p>
 *
 * @author 周光兵
 */
public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();

        int workingSec = 2;
        int threadCount = 5;

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(getName() + "：线程开始工作 " + LocalTime.now());

                try {
                    synchronized (locker) {
                        sleepSec(workingSec);
                        System.out.println(getName() + "：线程进入等待 " + LocalTime.now());

                        locker.wait();

                        System.out.println(getName() + "：线程继续 " + LocalTime.now());
                        sleepSec(workingSec);
                        System.out.println(getName() + "：线程结束 " + LocalTime.now());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "工作线程" + i).start();
        }

        System.out.println("================== 唤醒线程开始Sleep =================== " + LocalTime.now());
        sleepSec(workingSec + 1);

        System.out.println("================== 唤醒线程Sleep结束 =================== " + LocalTime.now());
        synchronized (locker) {
            System.out.println("开始唤醒所有 " + LocalTime.now());
            /*
             * 若在locker.wait()执行之前，调用notifyAll/notify，后续线程不会被唤醒。Lost notification
             */

            locker.notifyAll();

//            for (int i = 0; i < threadCount; i++) {
//                System.out.println("================== 开始逐个唤醒 =================== " + LocalTime.now());
//                locker.notify();
//            }

        }

    }

    private static void sleepSec(int workingSec) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(workingSec));
    }

    public static String getName() {
        return Thread.currentThread().getName();
    }
}

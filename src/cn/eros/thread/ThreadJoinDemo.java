package cn.eros.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>Create time: 2020/6/4 23:02</p>
 *
 * @author 周光兵
 */
public class ThreadJoinDemo {
    private static final List<String> CONTENTS = new ArrayList<>();
    private static int WORKING_DURATION = 0;

    public static void main(String[] args) throws InterruptedException {
        long mainStart = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "：开始抓取网页内容");
                long start = System.currentTimeMillis();
                String content = getContentFromWeb();
                long threadWorkingDuration = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + "：抓取网页内容结束");
                synchronized (CONTENTS) {
                    CONTENTS.add(content);
                    WORKING_DURATION += threadWorkingDuration;
                }
            }, "Thread-" + i);

            thread.start();
            threads.add(thread);
        }

        // Sleep一下，让线程都启动起来
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        System.out.println("======================== 主线程开始Join ==================");

        for (Thread thread : threads) {
            String threadName = thread.getName();
            System.out.println("======================== 主线程开始Join " + threadName + " ==================");
            /*
             * join方法，会等待调用join方法的线程执行完毕。
             * 即：等待当前的thread执行完毕
             */
            thread.join();
            System.out.println("======================== 主线程Join " + threadName + " 结束 ==================");
        }

        System.out.println("======================== 主线程Join结束 ==================");
        CONTENTS.forEach(s -> {
            System.out.print(s.length() + "：");
            System.out.println(s);
        });

        long mainWorkingDuration = System.currentTimeMillis() - mainStart;
        System.out.println("工作线程累计工作时间：" + WORKING_DURATION);
        System.out.println("主线程工作时间：" + mainWorkingDuration);
    }

    private static String getContentFromWeb() {
        StringBuilder ret = new StringBuilder();
        int len = ((int) (Math.random() * 1000000)) % 4096 + 1024;
        for (int i = 0; i < len; i++) {
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ret.toString();
    }
}

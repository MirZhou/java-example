package cn.eros.thread.waitnotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * <p>Create time: 2020/6/4 22:41</p>
 *
 * @author 周光兵
 */
public class ProducerConsumerAppMain {
    public static void main(String[] args) {
        // 队列，先进先出
        Queue<String> urls = new LinkedList<>();

        Consumer<String> consumer = new Consumer<>(urls);
        Producer<String> producer = new Producer<>(urls, 1024);

        for (int i = 0; i < 100; i++) {
            Thread consumerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = consumer.consume();
                        processURL(url);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "消费者-" + i);

            consumerThread.start();

        }

        for (int i = 0; i < 3; i++) {
            Thread producerThread = new Thread(() -> {
                while (true) {
                    String url = produceURL();
                    try {
                        producer.product(url);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "生产者-" + i);

            producerThread.start();
        }
    }

    private static String produceURL() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("www.");

        for (int i = 0; i < 6; i++) {
            int rand = ThreadLocalRandom.current().nextInt(26);

            char ch = (char) (rand + 'a');

            stringBuilder.append(ch);
        }

        stringBuilder.append(".com");

        return stringBuilder.toString();
    }

    private static void processURL(String url) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " -> 开始处理:" + url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        System.out.println(Thread.currentThread().getName() + " -> 处理完成：" + url);

    }
}

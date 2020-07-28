package cn.eros.design.pattern;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * <p>create time：2020-07-28 09:25
 *
 * @author Eros
 */
public class SingletonTest {
    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        /*
         * 总结：
         * 1、HashSet 非线程安全，可替换为CopyOnWriteArraySet
         * 2、普通单例模式不适用于并发场景，需要并发场景时，可使用“双检索”机制
         */

        System.out.println("============================================================ " + System.currentTimeMillis());

        testSingleton();
        testVolatileSingleton();

        latch.await();
    }

    private static void testSingleton() {
        System.out.println("============================================================ " + System.currentTimeMillis());
        ExecutorService executor = Executors.newFixedThreadPool(20);

        Set<String> stringSet = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 2000; i++) {
            executor.execute(() -> {
                Singleton singleton = Singleton.getInstance();

                stringSet.add(singleton.toString());
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stringSet.forEach(System.out::println);

        if (stringSet.size() > 1) {
            System.out.println(stringSet.size());
        }

        latch.countDown();
    }

    private static void testVolatileSingleton() {
        System.out.println("============================================================ " + System.currentTimeMillis());
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Set<String> stringSet = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 2000; i++) {
            executor.execute(() -> {
                stringSet.add(VolatileSingleton.getInstance().toString());
            });
        }

        executor.shutdown();


        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stringSet.forEach(System.out::println);

        if (stringSet.size() > 1) {
            System.out.println(stringSet.size());
        }

        latch.countDown();
    }
}

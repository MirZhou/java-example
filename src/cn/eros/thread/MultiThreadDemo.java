package cn.eros.thread;

/**
 * 测试线程上下文切换Demo
 *
 * @author Eros
 * @date 2021/04/01 13:54
 */
public class MultiThreadDemo {
    public static void main(String[] args) {
        ThreadContextSwitchTester multiThreadTester = new MultiThreadTester();
        multiThreadTester.start();

        ThreadContextSwitchTester serialtTester = new SerialTester();
        serialtTester.start();
    }

    static class MultiThreadTester extends ThreadContextSwitchTester {

        @Override
        public void start() {
            long start = System.currentTimeMillis();
            
            MyRunnable myRunnable = new MyRunnable();
            Thread[] threads = new Thread[4];

            // 创建多个线程
            for (int i = 0; i < 4; i++) {
                threads[i] = new Thread(myRunnable);
                threads[i].start();
            }

            for (Thread thread : threads) {
                try {
                    // 等待线程执行完毕
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long end = System.currentTimeMillis();
            
            System.out.printf("multi thread exec time: %d s\n", (end - start));
            System.out.println("counter:" + super.getCounter());
        }

        class MyRunnable implements Runnable {

            @Override
            public void run() {
                while(counter < 100000000) {
                    synchronized (this) {
                        if (counter < 100000000) {
                            increaseCounter();
                        }
                    }
                }
            }

        }

    }

    static class SerialTester extends ThreadContextSwitchTester {
        @Override
        public void start() {
            long start = System.currentTimeMillis();

            for (int i = 0; i < COUNT; i++) {
                super.increaseCounter();
            }

            long end = System.currentTimeMillis();

            System.out.printf("serial exec time: %d s\n", (end - start));
            System.out.println("counter:" + super.getCounter());
        }
    }

    static abstract class ThreadContextSwitchTester {
        public static final int COUNT = 100000000;
        public volatile int counter = 0;

        public int getCounter() {
            return this.counter;
        }

        public void increaseCounter() {
            this.counter += 1;
        }

        public abstract void start();
    }
}
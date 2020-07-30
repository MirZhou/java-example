package cn.eros.concurrent;

/**
 * 简单死锁实现Demo
 * <p>create time：2020-07-30 09:11
 *
 * @author Eros
 */
public class DeadLockSimpleDemo extends Thread {
    private final String first;
    private final String second;

    public DeadLockSimpleDemo(String threadName, String first, String second) {
        super(threadName);

        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained:" + this.first);
            try {
                Thread.sleep(1000L);

                synchronized (second) {
                    System.out.println(this.getName() + " obtained:" + this.second);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";

        DeadLockSimpleDemo thread1 = new DeadLockSimpleDemo("Thread1", lockA, lockB);
        DeadLockSimpleDemo thread2 = new DeadLockSimpleDemo("Thread2", lockB, lockA);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

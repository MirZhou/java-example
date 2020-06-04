package cn.eros.thread.waitnotify;

import java.util.Queue;

/**
 * <p>Create time: 2020/6/4 22:41</p>
 *
 * @author 周光兵
 */
public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException {
        synchronized (tasks) {
            while (tasks.size() == 0) {
                System.out.println("消费者线程进入等待 -> " + Thread.currentThread().getName());
                tasks.wait();
            }

            T ret = tasks.poll();
            tasks.notifyAll();

            return ret;
        }
    }
}

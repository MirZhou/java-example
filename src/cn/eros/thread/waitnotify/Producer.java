package cn.eros.thread.waitnotify;

import java.util.Queue;

/**
 * <p>Create time: 2020/6/4 22:36</p>
 *
 * @author 周光兵
 */
public class Producer<T> {
    private final Queue<T> tasks;
    private int maxTaskCount = 0;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    public void product(T task) throws InterruptedException {
        synchronized (tasks) {
            while (this.tasks.size() >= this.maxTaskCount) {
                System.out.println("生产者线程进入等待 -> " + Thread.currentThread().getName());
                this.tasks.wait();
            }

            this.tasks.add(task);
            this.tasks.notifyAll();
        }
    }
}

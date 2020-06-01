package cn.eros.thread;

/**
 * <p>Create time: 2020/6/1 22:45</p>
 *
 * @author 周光兵
 */
public class DataHolder {
    private long number = 0;
    private static long numberStatic = 0;

    public void changeSyncBlock(long delta) {
        synchronized (this) {
            this.number += delta;
        }
    }

    public synchronized void change(long delta) {
        this.number += delta;
    }

    public synchronized static void changeStatic(long delta) {
        numberStatic += delta;
    }

    public void print() {
        System.out.println("Number=" + this.number);
    }

    public static void printStatic() {
        System.out.println("Number=" + numberStatic);
    }
}

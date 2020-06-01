package cn.eros.thread;

/**
 * <p>Create time: 2020/6/1 22:44</p>
 *
 * @author 周光兵
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        Thread increaseThread = new Thread(new ChangeData(-2, Integer.MAX_VALUE / 50, dataHolder));
        Thread decreaseThread = new Thread(new ChangeData(2, Integer.MAX_VALUE / 50, dataHolder));

        System.out.println("开始执行");
        increaseThread.start();
        decreaseThread.start();
    }
}

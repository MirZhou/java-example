package cn.eros.thread;

/**
 * <p>Create time: 2020/6/1 23:19</p>
 *
 * @author 周光兵
 */
public class ChangeData implements Runnable {
    private long delta;
    private long loopCount;
    private DataHolder dataHolder;

    public ChangeData(long delta, long loopCount, DataHolder dataHolder) {
        this.delta = delta;
        this.loopCount = loopCount;
        this.dataHolder = dataHolder;
    }

    @Override
    public void run() {
        for (int i = 1; i < loopCount; i++) {
            dataHolder.changeSyncBlock(delta);
//            DataHolder.changeStatic(delta);
        }

        System.out.println("Thread Name:" + Thread.currentThread().getName());
        dataHolder.print();
//        DataHolder.printStatic();
    }

}

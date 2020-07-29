package cn.eros.design.pattern;

/**
 * <p>create time：2020-07-28 09:53
 *
 * @author Eros
 */
public class VolatileSingleton {
    // volatile负责保证可见性
    private static volatile VolatileSingleton instance = null;

    private VolatileSingleton() {
    }

    public static VolatileSingleton getInstance() {
        // 尽量避免进入同步块
        if (instance == null) {
            synchronized (VolatileSingleton.class) {
                if (instance == null) {
                    instance = new VolatileSingleton();
                }
            }
        }

        return instance;
    }

}

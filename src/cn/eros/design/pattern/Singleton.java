package cn.eros.design.pattern;

/**
 * <p>create time：2020-07-28 09:22
 *
 * @author Eros
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {};

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

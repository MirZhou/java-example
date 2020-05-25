package cn.eros.supermarket2;

/**
 * <p>Create time: 2020/5/17 18:11</p>
 *
 * @author 周光兵
 */
public class OverloadAndOverrideTestMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("Eros", "天英路", 500, 600, 100);
        MerchandiseV2 m = superMarket.getMerchandiseOf(3);

        System.out.println(m.getClass().getName());
        m.buy(true);
        System.out.println();
        m.buy(1);
        System.out.println();
        m.buy(3);
        System.out.println();
        m.buy(6);

        m = superMarket.getMerchandiseOf(10);
        System.out.println(m.getClass().getName());
        m.buy(true);
        System.out.println();
        m.buy(1);
        System.out.println();
        m.buy(3);
        System.out.println();
        m.buy(6);


        m = superMarket.getMerchandiseOf(100);
        System.out.println(m.getClass().getName());
        m.buy(true);
        System.out.println();
        m.buy(1);
        System.out.println();
        m.buy(3);
        System.out.println();
        m.buy(6);
    }
}

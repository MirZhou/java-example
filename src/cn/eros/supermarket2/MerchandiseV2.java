package cn.eros.supermarket2;

/**
 * 普通商品
 * <p>Create time: 2020/5/17 16:38</p>
 *
 * @author 周光兵
 */
public class MerchandiseV2 {
    private String name;
    private String id;
    private int count;
    private double soldPrice;
    private double purchasePrice;

    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public MerchandiseV2(String name, String id, int count, double soldPrice) {
        this(name, id, count, soldPrice, soldPrice * 0.8);
    }

    public MerchandiseV2() {
        this("无名", "000", 0, 1, 1.1);
    }

    public void describe() {
        String sb = "商品名：" + this.name + "\n" +
                "商品ID：" + this.id + "\n" +
                "售价：" + this.soldPrice + "\n" +
                "进价：" + this.purchasePrice + "\n" +
                "库存：" + this.count + "\n" +
                "单品毛利润：" + this.calculateProfit();

        System.out.println(sb);
    }

    /**
     * 计算毛利润
     *
     * @return 毛利润
     */
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;

        if (profit <= 0) {
            profit = 0;
        }

        return profit;
    }

    public double buy(int count) {
        System.out.println("Merchandise 里的 buy (int count)");
        if (this.count < count) {
            System.out.println(" 购买失败，库存不够 ");
            return -1;
        }
        this.count -= count;
        double cost = count * soldPrice;
        System.out.println(" 购买成功，花费为 " + cost);
        return cost;
    }


    public double buy(boolean reallyBuy) {
        System.out.println("Merchandise 里的 buy (boolean reallyBuy)");
        if (reallyBuy) {
            return this.buy(1);
        } else {
            return -1;
        }
    }

    // getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}

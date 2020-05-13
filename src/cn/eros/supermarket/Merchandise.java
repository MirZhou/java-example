package cn.eros.supermarket;

/**
 * 商品
 * <p>Create time: 2020/5/13 23:59</p>
 *
 * @author 周光兵
 */
public class Merchandise {
    /**
     * 商品ID
     */
    String id;
    /**
     * 商品名
     */
    String name;
    /**
     * 数量（库存）
     */
    Integer count;
    /**
     * 售价
     */
    Double soldPrice;
    /**
     * 进价
     */
    Double purchasePrice;

    public void init(String id, String name, Integer count, Double soldPrice, Double purchasePrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }
}

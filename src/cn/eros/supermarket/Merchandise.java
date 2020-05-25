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
    private String id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 数量（库存）
     */
    private Integer count;
    /**
     * 售价
     */
    private Double soldPrice;
    /**
     * 进价
     */
    private Double purchasePrice;

    public Merchandise(String id, String name, Integer count, Double soldPrice, Double purchasePrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}

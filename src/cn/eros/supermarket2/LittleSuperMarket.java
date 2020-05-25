package cn.eros.supermarket2;

/**
 * 初始化小超市
 * <p>Create time: 2020/5/17 16:36</p>
 *
 * @author 周光兵
 */
public class LittleSuperMarket {
    private String superMarketName;
    private String address;
    private Integer parkingCount;
    private Double incomingSum;
    private MerchandiseV2[] merchandises;
    private int[] merchandiseSold;

    /**
     * 初始化小超市
     *
     * @param superMarketName  超市名
     * @param address          地址
     * @param parkingCount     商品数
     * @param merchandiseCount 商品种类数
     * @param count            每种商品缺省库存
     */
    public LittleSuperMarket(String superMarketName, String address, Integer parkingCount,
                             int merchandiseCount, int count) {
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        this.merchandises = new MerchandiseV2[merchandiseCount];

        for (int i = 0; i < merchandiseCount; i++) {
            // 创建手机、变色壳手机和普通商品，都放在商品数组里
            MerchandiseV2 m = null;

            if (i > 0 && i % 100 == 0) {
                // 变色壳手机
                m = new ShellColorChangePhone(
                        " 商品 " + i,
                        "ID" + i,
                        count,
                        1999D,
                        999D,
                        4.5,
                        3.5,
                        4,
                        128,
                        " 三星 ",
                        "Android"
                );

            } else {
                if (i > 0 && i % 10 == 0) {
                    // 手机
                    m = new Phone(
                            " 商品 " + i,
                            "ID" + i,
                            count,
                            1999D,
                            999D,
                            4.5,
                            3.5,
                            4,
                            128,
                            " 索尼 ",
                            "Android"
                    );
                } else {
                    // 普通商品
                    double purchasePrice = Math.random() * 200;

                    m = new MerchandiseV2(
                            " 商品 " + i,
                            "ID" + i,
                            count,
                            purchasePrice * (1 + Math.random()),
                            purchasePrice
                    );
                }
            }

            // 用创建的商品，给商品数组的第i个引用赋值，all和小超市的商品线上服务指向的是同一个数组对象
            this.merchandises[i] = m;
        }
    }

    // 一些特殊的逻辑

    /**
     * 得到利润最高的商品
     *
     * @return 利润最高的商品
     */
    public MerchandiseV2 getBiggestProfitMerchandise() {
        MerchandiseV2 curr = null;
        for (MerchandiseV2 m : merchandises) {
            // 这个逻辑有问题吗？相同的利润怎么判断？
            if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }

    /**
     * 根据索引获取商品
     *
     * @param merchandiseIndex 商品索引
     * @return 商品
     */
    public MerchandiseV2 getMerchandiseOf(int merchandiseIndex) {
        if (merchandiseIndex < 0 || merchandiseIndex >= merchandises.length) {
            return null;
        }
        return merchandises[merchandiseIndex];
    }

    /**
     * 赚钱
     *
     * @param toBeAdded 收益
     */
    public void addIncomingSum(double toBeAdded) {
        this.incomingSum += toBeAdded;
    }

    /**
     * 花钱
     *
     * @param toBeSpent 花费
     * @return 状态
     */
    public boolean spendMoney(double toBeSpent) {
        if (toBeSpent > incomingSum) {
            return false;
        }
        incomingSum -= toBeSpent;
        return true;
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(Integer parkingCount) {
        this.parkingCount = parkingCount;
    }

    public Double getIncomingSum() {
        return incomingSum;
    }

    public void setIncomingSum(Double incomingSum) {
        this.incomingSum = incomingSum;
    }

    public MerchandiseV2[] getMerchandises() {
        return merchandises;
    }

    public void setMerchandises(MerchandiseV2[] merchandises) {
        this.merchandises = merchandises;
    }

    public int[] getMerchandiseSold() {
        return merchandiseSold;
    }

    public void setMerchandiseSold(int[] merchandiseSold) {
        this.merchandiseSold = merchandiseSold;
    }
}

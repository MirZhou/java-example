package cn.eros.supermarket2;

/**
 * <p>Create time: 2020/5/17 17:01</p>
 *
 * @author 周光兵
 */
public class Phone extends MerchandiseV2 {
    private double screenSize;
    private double cpuHz;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;

    private static int MAX_BUY_ONE_ORDER = 5;

    public Phone(String id, String name, Integer count, Double soldPrice, Double purchasePrice,
                 double screenSize, double cpuHz, int memoryG, int storageG, String brand, String os) {
        super(id, name, count, soldPrice, purchasePrice);

        this.screenSize = screenSize;
        this.cpuHz = cpuHz;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;
    }

    @Override
    public double buy(int count) {
        System.out.println("Phone 里的 buy (int count)");
        if (count > MAX_BUY_ONE_ORDER) {
            System.out.println(" 购买失败，手机一次最多只能买 " + MAX_BUY_ONE_ORDER + " 个 ");
            return -2;
        }
        return super.buy(count);
    }

    @Override
    public String getName() {
        return this.brand + ":" + this.os + ":" + super.getName();
    }

    @Override
    public void describe() {
        System.out.println(" 此手机商品属性如下 ");
        super.describe();
        System.out.println(" 手机厂商为 " + brand + "；系统为 " + os + "；硬件配置如下：\n" +
                " 屏幕：" + screenSize + " 寸 \n" +
                "cpu 主频 " + cpuHz + " GHz\n" +
                " 内存 " + memoryG + "Gb\n" +
                " 存储空间 " + storageG + "Gb");
    }

    // getter and setter

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCpuHz() {
        return cpuHz;
    }

    public void setCpuHz(double cpuHz) {
        this.cpuHz = cpuHz;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}

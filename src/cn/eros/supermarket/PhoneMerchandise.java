package cn.eros.supermarket;

/**
 * 手机
 * <p>Create time: 2020/5/14 23:47</p>
 *
 * @author 周光兵
 */
public class PhoneMerchandise extends Merchandise {
    private double screenSize;
    private double cpuHz;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;

    public PhoneMerchandise(String id, String name, Integer count, Double soldPrice, Double purchasePrice,
                            double screenSize, double cpuHz, int memoryG, int storageG, String brand, String os) {
        super(id, name, count, soldPrice, purchasePrice);

        this.screenSize = screenSize;
        this.cpuHz = cpuHz;
        this.memoryG = memoryG;
        this.storageG= storageG;
        this.brand = brand;
        this.os = os;
    }

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

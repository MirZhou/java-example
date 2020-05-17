package cn.eros.supermarket2;

/**
 * <p>Create time: 2020/5/17 17:22</p>
 *
 * @author 周光兵
 */
public class ShellColorChangePhone extends Phone{
    private boolean enableShellColorChange;

    public ShellColorChangePhone(String id, String name, Integer count, Double soldPrice, Double purchasePrice, double screenSize, double cpuHz, int memoryG, int storageG, String brand, String os) {
        super(id, name, count, soldPrice, purchasePrice, screenSize, cpuHz, memoryG, storageG, brand, os);

        this.enableShellColorChange = false;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println(" 壳色随着屏幕色变的功能开启状态：" + enableShellColorChange);
    }

    @Override
    public double calculateProfit() {
        // TODO 手机太奇葩不好卖，厂家提供 10 个点的返点
        return super.calculateProfit() + super.getPurchasePrice() * 0.1;
    }

    @Override
    public double buy(int count) {
        System.out.println("ShellColorChangePhone 里的 buy (int count)");
        if (count < 2) {
            System.out.println(" 买一送一了解一下，不单卖哦！");
            return -1;
        }
        return super.buy(count);
    }

    // getter and setter

    public boolean isEnableShellColorChange() {
        return enableShellColorChange;
    }

    public void setEnableShellColorChange(boolean enableShellColorChange) {
        this.enableShellColorChange = enableShellColorChange;
    }
}

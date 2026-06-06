/**
 * 抽象类 FarmAsset —— 农场中所有资产（动物、机器、物资等）的基类。
 * 所有资产都有名称和基础价值，但计算当前价值的方式由子类实现。
 */
public abstract class FarmAsset {
    protected String name;      // 资产名称
    protected double baseCost;  // 初始购买成本 / 基础价值

    /**
     * 构造函数
     * @param name  资产名称
     * @param cost  基础成本
     */
    public FarmAsset(String name, double cost) {
        this.name = name;
        this.baseCost = cost;
    }

    /**
     * 返回资产基本信息（名称和基础成本）
     * @return 描述字符串
     */
    public String getAssetInfo() {
        return "Asset: " + name + ", Base Cost: $" + baseCost;
    }

    /**
     * 抽象方法：获取资产当前价值。
     * 不同资产计算方式不同（例如机器折旧、动物按体重等）。
     * @return 当前价值
     */
    public abstract double getCurrentValue();
}
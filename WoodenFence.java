/**
 * 木围栏 —— 静止资产，无特殊功能接口。
 * 价值 = 每米单价 × 长度，不考虑折旧。
 */
public class WoodenFence extends FarmAsset {
    private double length; // 围栏长度（米）

    /**
     * @param name     资产名称
     * @param baseCost 每米单价（基础成本）
     * @param length   围栏长度
     */
    public WoodenFence(String name, double baseCost, double length) {
        super(name, baseCost);
        this.length = length;
    }

    @Override
    public double getCurrentValue() {
        return baseCost * length;
    }
}
/**
 * 奶牛 —— 既是资产，又可维护（喂食）和可收获（产奶）。
 * 饥饿时不能产奶，喂食后可产奶一次，随后恢复饥饿。
 */
public class DairyCow extends FarmAsset implements IMaintainable, IHarvestable {
    private double weight;   // 体重（kg）
    private boolean isHungry; // 是否饥饿，初始 true

    /**
     * @param name     名称
     * @param baseCost 基础成本
     * @param weight   体重
     */
    public DairyCow(String name, double baseCost, double weight) {
        super(name, baseCost);
        this.weight = weight;
        this.isHungry = true;
    }

    @Override
    public double getCurrentValue() {
        return baseCost + (weight * 15.0);
    }

    // ---------- IMaintainable 实现 ----------
    @Override
    public double performMaintenance() {
        double cost = weight * 0.1;
        isHungry = false;       // 喂食后不再饥饿
        return cost;
    }

    @Override
    public String getMaintenanceDetail() {
        return "喂食牧草";
    }

    // ---------- IHarvestable 实现 ----------
    @Override
    public boolean isHarvestable() {
        return !isHungry;       // 只有不饿时才能产奶
    }

    @Override
    public String harvest() {
        if (isHungry) {
            return null;        // 饥饿状态无法产奶
        }
        isHungry = true;        // 产奶后变饿
        return "20L Milk";
    }

    // ---------- 重写信息方法 ----------
    @Override
    public String getAssetInfo() {
        return super.getAssetInfo() + ", Weight: " + weight + " kg";
    }
}
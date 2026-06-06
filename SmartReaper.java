/**
 * 智能收割机 —— 资产，需要维护（充电/润滑），但不可收获。
 * 价值按每年折旧 10% 计算。
 */
public class SmartReaper extends FarmAsset implements IMaintainable {
    private double efficiency;   // 收割效率（如 0.8）
    private int yearOfService;   // 已服役年限

    /**
     * @param name          名称
     * @param baseCost      基础成本（原值）
     * @param efficiency    收割效率
     * @param yearOfService 服役年数
     */
    public SmartReaper(String name, double baseCost, double efficiency, int yearOfService) {
        super(name, baseCost);
        this.efficiency = efficiency;
        this.yearOfService = yearOfService;
    }

    @Override
    public double getCurrentValue() {
        return baseCost * Math.pow(0.9, yearOfService);
    }

    // ---------- IMaintainable 实现 ----------
    @Override
    public double performMaintenance() {
        System.out.println("Reaper charged");
        return 150.0;   // 固定维护费用
    }

    @Override
    public String getMaintenanceDetail() {
        return "Reaper charged";
    }

    // ---------- 重写信息方法 ----------
    @Override
    public String getAssetInfo() {
        return super.getAssetInfo() +
               ", Efficiency: " + efficiency +
               ", Years of Service: " + yearOfService;
    }
}
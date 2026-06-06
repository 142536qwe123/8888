/**
 * 苹果树 —— 资产，同时是可收获作物。
 * 价值随树龄增加，结果需满足树龄>3且已浇水。
 */
public class AppleTree extends FarmAsset implements IHarvestable {
    private int age;           // 树龄（年）
    private boolean isWatered; // 是否已浇水，默认 false

    /**
     * @param name     名称
     * @param baseCost 基础成本
     * @param age      初始树龄
     */
    public AppleTree(String name, double baseCost, int age) {
        super(name, baseCost);
        this.age = age;
        this.isWatered = false;
    }

    /** 浇水操作 */
    public void water() {
        isWatered = true;
    }

    @Override
    public double getCurrentValue() {
        return baseCost + (age * 10.0);
    }

    @Override
    public boolean isHarvestable() {
        return age > 3 && isWatered;
    }

    @Override
    public String harvest() {
        if (isHarvestable()) {
            isWatered = false;          // 收获后需重新浇水
            return "Box of Apples";
        }
        return null;
    }
}
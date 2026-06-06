/**
 * 可收获接口 —— 适用于能产出产品的资产（动物产奶、农作物结果等）。
 */
public interface IHarvestable {
    /**
     * 判断当前是否可收获。
     * @return 可收获返回 true，否则 false
     */
    boolean isHarvestable();

    /**
     * 执行收获动作，返回收获的具体物品名称。
     * @return 收获物品描述（如 "5L Milk"）
     */
    String harvest();
}
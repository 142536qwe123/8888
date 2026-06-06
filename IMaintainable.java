/**
 * 可维护接口 —— 适用于需要喂食、维修、充电等维护操作的资产。
 */
public interface IMaintainable {
    /**
     * 执行维护动作，并返回本次维护产生的费用。
     * @return 维护费用
     */
    double performMaintenance();

    /**
     * 返回维护内容的文本描述。
     * @return 描述字符串（如 "更换机油", "喂食牧草"）
     */
    String getMaintenanceDetail();
}
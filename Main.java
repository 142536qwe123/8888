public class Main {
    public static void main(String[] args) {
        String expression = "(S, (P, 10, 20), (S, 8, 10))";
        Task task = TaskParser.parse(expression);

        System.out.println("原始表达式: " + expression);
        System.out.println("解析结果: " + task);
        System.out.println("总耗时 = " + task.getDuration());
        System.out.println(GanttChart.render(task));
    }
}
// 测试类
public class TaskTest {
    public static void main(String[] args) {
        String[] expressions = {
                "(S, (S, 2, 3), 4)",
                "(P, 100, (S, 50, 50))",
                "(S, (P, 10, 20), (P, 15, 5))",
                "(P, (S, (P, 2, 2), 3), (S, 4, 4))"
        };

        for (String expression : expressions) {
            Task task = TaskParser.parse(expression);
            System.out.println("表达式: " + expression);
            System.out.println("解析结果: " + task + " 总耗时 = " + task.getDuration());
            System.out.println(GanttChart.render(task));
        }
    }
}
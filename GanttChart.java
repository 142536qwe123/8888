import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class GanttChart {
    private GanttChart() {
    }

    public static String render(Task task) {
        List<Task.AtomicTaskSpan> spans = new ArrayList<Task.AtomicTaskSpan>(task.collectAtomicTasks());
        Collections.sort(spans, new Comparator<Task.AtomicTaskSpan>() {
            @Override
            public int compare(Task.AtomicTaskSpan left, Task.AtomicTaskSpan right) {
                if (left.getStartTime() != right.getStartTime()) {
                    return left.getStartTime() - right.getStartTime();
                }
                if (left.getEndTime() != right.getEndTime()) {
                    return left.getEndTime() - right.getEndTime();
                }
                return left.getTask().getDuration() - right.getTask().getDuration();
            }
        });

        StringBuilder builder = new StringBuilder();
        builder.append("时间区间甘特图\n");
        for (Task.AtomicTaskSpan span : spans) {
            builder.append(String.format("[%d, %d) 任务=%s\n", span.getStartTime(), span.getEndTime(), span.getTask()));
        }
        return builder.toString();
    }
}
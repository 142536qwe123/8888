import java.util.ArrayList;
import java.util.List;

// 抽象基类
public abstract class Task {
    public abstract int getDuration();
    public abstract String toString();

    protected abstract void collectAtomicTasks(int startTime, List<AtomicTaskSpan> result);

    public final List<AtomicTaskSpan> collectAtomicTasks() {
        List<AtomicTaskSpan> result = new ArrayList<AtomicTaskSpan>();
        collectAtomicTasks(0, result);
        return result;
    }

    public static final class AtomicTaskSpan {
        private final AtomicTask task;
        private final int startTime;
        private final int endTime;

        public AtomicTaskSpan(AtomicTask task, int startTime, int endTime) {
            this.task = task;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public AtomicTask getTask() {
            return task;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getDuration() {
            return endTime - startTime;
        }
    }
}


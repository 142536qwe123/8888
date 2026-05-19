import java.util.List;

// 并行任务
class ParallelTask extends CompositeTask {
    public ParallelTask(Task left, Task right) {
        super(left, right);
    }

    @Override
    public int getDuration() {
        return Math.max(left.getDuration(), right.getDuration());
    }

    @Override
    public String toString() {
        return "(P, " + left.toString() + ", " + right.toString() + ")";
    }

    @Override
    protected void collectAtomicTasks(int startTime, List<AtomicTaskSpan> result) {
        left.collectAtomicTasks(startTime, result);
        right.collectAtomicTasks(startTime, result);
    }
}
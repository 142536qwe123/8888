import java.util.List;

// 串行任务
class SerialTask extends CompositeTask {
    public SerialTask(Task left, Task right) {
        super(left, right);
    }

    @Override
    public int getDuration() {
        return left.getDuration() + right.getDuration();
    }

    @Override
    public String toString() {
        return "(S, " + left.toString() + ", " + right.toString() + ")";
    }

    @Override
    protected void collectAtomicTasks(int startTime, List<AtomicTaskSpan> result) {
        left.collectAtomicTasks(startTime, result);
        right.collectAtomicTasks(startTime + left.getDuration(), result);
    }
}
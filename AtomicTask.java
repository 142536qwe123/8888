import java.util.List;

// 原子任务
class AtomicTask extends Task {
    private final int time;

    public AtomicTask(int time) {
        this.time = time;
    }

    @Override
    public int getDuration() {
        return time;
    }

    @Override
    public String toString() {
        return String.valueOf(time);
    }

    @Override
    protected void collectAtomicTasks(int startTime, List<AtomicTaskSpan> result) {
        result.add(new AtomicTaskSpan(this, startTime, startTime + time));
    }
}
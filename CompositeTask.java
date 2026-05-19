// 组合任务抽象类
abstract class CompositeTask extends Task {
    protected Task left;
    protected Task right;

    public CompositeTask(Task left, Task right) {
        this.left = left;
        this.right = right;
    }
}
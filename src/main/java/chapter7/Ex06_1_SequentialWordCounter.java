package chapter7;

public class Ex06_1_SequentialWordCounter {

    private int counter;
    private boolean lastSpace;

    public Ex06_1_SequentialWordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public void addCounter(int count, boolean lastSpace) {
        counter+=count;
        this.lastSpace = lastSpace;
    }

    public void setLastSpace(boolean lastSpace) {
        this.lastSpace = lastSpace;
    }

    public int getCounter() {
        return counter;
    }

    public boolean isLastSpace() {
        return lastSpace;
    }
}

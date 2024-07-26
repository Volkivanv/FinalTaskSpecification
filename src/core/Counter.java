package src.core;

public class Counter {
    private int count;
    public Counter() {
        this.count = 0;
    }

    public synchronized void add() {
        count++;
    }
    public synchronized void sub() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }

}

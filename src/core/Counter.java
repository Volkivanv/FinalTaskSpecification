package src.core;

public class Counter implements AutoCloseable{
//    private int count;
    public Counter() {
//        this.count = 0;
    }

    public synchronized Integer add(Integer count) {
        Integer newCount = count+1;
        return newCount;
    }
    public synchronized Integer sub(Integer count) {
        Integer newCount = count;
        if(count > 0 ) newCount--;
        return newCount;
    }

//    public synchronized int getCount() {
//        return count;
//    }

    @Override
    public void close() throws Exception {
        System.out.println("counter closed");
    }
}

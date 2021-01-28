package queue;


class ArrayQueue {

    private int mMaxSize = -1;
    private int mFront = -1;
    private int mLast = -1;
    private int[] mArray = null;

    public ArrayQueue(int maxSize) {
        if(maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        mMaxSize = maxSize;
        mArray = new int[mMaxSize];
    }

    private boolean isFull() {
        return mLast == mMaxSize - 1;
    }

    private boolean isEmpty() {
        return mFront == mLast + 1;
    }

    public void add(int value) {
        if(isFull()) {
            throw new RuntimeException("array queue is full");
        }
        mLast++;
        mArray[mLast] = value;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("array queue is empty");
        }
        mFront++;
        return mArray[mFront];
    }

    public int get() {
        if(isEmpty()) {
            throw new RuntimeException("array queue is empty");
        }
        if(mFront == -1) {
            return mArray[0];
        } else {
            return mArray[mFront];
        }
    }

    public void dump() {
        for(int i= 0; i < mArray.length; i++) {
            System.out.println("index:"+i+ "    value:"+mArray[i]);
        }
    }



}



public class ArrayQueueDome {
    public static void main(String[] argc) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for(int i = 0; i < 10; i++) {
            arrayQueue.add(i);
        }

        for(int i = 0; i < 10; i++) {
           int v1 = arrayQueue.peek();
           int v2 = arrayQueue.get();

           System.out.println("peek:"+v1  +"    get:"+v2);
        }
       // arrayQueue.dump();
    }
}

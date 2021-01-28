package queue;


import java.lang.management.MemoryManagerMXBean;

class CircleQueue {
    private int  mMaxSize = -1;
    private int mFront = 0;
    private int mLast = 0;
    private int[] mArray = null;

    public CircleQueue(int maxSize) {
        mMaxSize = maxSize;
        mArray = new int[mMaxSize];
    }

    private boolean isEmpty() {
        return mLast == mFront;
    }

    private boolean isFull() {
        return mLast % mMaxSize == mFront % mMaxSize;
    }


    public void add(int value) {
        System.out.println(mLast +"======="+mFront +"    value:"+value + "   index:  " +(mLast % mMaxSize));
        if(isFull() && !isEmpty()) {
            System.out.println("队列已满");
            return;
        }
        mArray[mLast % mMaxSize] = value;
        mLast++;
    }

    public int peek() {
        System.out.println(mLast +"======="+mFront);
        if(isEmpty()) {
            System.out.println("队列空");
            return -1;
        }
        int value = mArray[mFront % mMaxSize];
        mFront++;
        return value;
    }

    public int size() {
        return mLast  - mFront;
    }

    public void dump() {
        System.out.println("dump===========start"+" mFront:"+mFront +" mFront index: "+ (mFront % mMaxSize) +"    size:"+ size());
        for(int i = mFront % mMaxSize; i < size() + (mFront % mMaxSize); i++) {
            System.out.println(mArray[i % mMaxSize]+"============"+ size() +"   mLast:"+mLast % mMaxSize+"   mFront:"+mFront % mMaxSize);
        }
        System.out.println("dump==========end");
    }


}


public class CircleQueueDome {
    public static void main(String[] argc) {
        CircleQueue queue = new CircleQueue(9);

        while (true) {
            System.out.println("add==========start");
            queue.add(100);
            queue.add(200);
            queue.add(300);
            queue.add(3333);
            System.out.println("add============end");


            queue.dump();



            System.out.println("peek===========start");
            queue.peek();
            queue.peek();
//            queue.peek();
//            queue.peek();
            System.out.println("peek=============end");


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//
//        queue.add(100);
//        queue.add(100);
//        queue.add(199);
//        queue.add(222);



  //      System.out.println("====================");


     //   queue.dump();

    }
}

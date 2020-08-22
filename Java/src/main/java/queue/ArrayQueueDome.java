package queue;

public class ArrayQueueDome {
}



class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据，模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列的尾部，指向队列尾部的数据（即就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否尾空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if(isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }

        rear++;//让rear后移
        arr[rear] = n;
    }

    //数据出队列
    public int getQueue() {
        //判断队列是否空
        if(isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println("队列空的，没有数据～～");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d", i, arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if(isEmpty()) {
            System.out.println("队列空，没有数据");
             throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front + 1];
    }
}
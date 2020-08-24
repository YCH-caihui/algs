package queue;

public class CircleArrayQueueDome {
    public static void main(String[] argc) {
        System.out.println("测试数组环形队列"+(-1 % 3));
        CircleArray array = new CircleArray(4);
        for(int i = 0; i < 3;i++) {
            array.addQueue(i);
            System.out.println(array.size());
        }
    }
}


class CircleArray {

    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = 0;//指向队列的尾部，指向队列尾部的数据（即就是队列最后一个数据）
    }


    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }


    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;

        return value;
    }


    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空");
        }

        for(int i = front; i <  front + size(); i++) {
            System.out.printf("arr[%d] = %d \n", 1 % maxSize,  arr[i % maxSize]);
        }


    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
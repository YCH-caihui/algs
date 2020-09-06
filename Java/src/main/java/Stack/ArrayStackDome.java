package Stack;

public class ArrayStackDome {

    public static void main(String[] args) {

    }
}

//定义一个ArrayStack 表示栈
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1; //top表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈pop，将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            System.out.println("栈空");
            throw new RuntimeException("栈空，没有数据-");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈,需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据～～");
            return;
        }
        for(int i = top; i >= 0; i--) {
            System.out.println("stack"+i +"  ="+stack[i]);
        }
    }

}

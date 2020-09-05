package linkedlist;

public class Josepfu {



    public static void main(String[] argc) {
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建first节点，当前么有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建成一个环形链表

    public void addBoy(int nums) {
        //  num 做一个数据校验
        if(nums < 1) {
            System.out.println("num的值不正确");
            return;
        }


        Boy curBoy = null;  //辅助指针，帮助构建环形链表
        //使用for来创建环形链表
        for(int i = 1; i <= nums; i++) {
            //根据编号来创建小孩节点
            Boy boy = new Boy(i);
            //如果四第一个小孩
            if(i == 1) {
                first = boy;
                first.setNext(first); //构成环
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if(first == null || startNo < 1 || startNo > nums ) {
            System.out.println("参数输入错误，请重新输入");
            return;
        }
        //创建要给辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //需求创建一个辅助指针(变量)helper, 事先指向环形链表的最后这个节点
        while (true) {
            if(helper.getNext() == first) {//说明helper 指向最后小孩节点
                if(helper.getNext() == first) {
                    break;
                }
                helper = helper.getNext();
            }
        }
        //小孩报数前，先让first和 helper移动 k-1 次
        for(int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m - 1次，然后出圈
        //这里是一个循环操作， 知道圈中只有一个人
        while (true) {
            if(helper == first) {
                break;
            }
            //让first和 helper同时移动countNUm - 1次
            for(int j = 0; j < countNum -1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println("最后留在圈中的小孩编号"+helper.getNo());
    }


    //遍历当前列表
    public void showBoy() {
        //判断链表是否为空
        if(first == null) {
            System.out.println("没有任何小孩--");
            return;
        }
        //因为first不能动，因此我们依然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo() +"\n");
            if(curBoy.getNext() == first) { //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); //curBoy后移
        }
    }
}


//创建一个boy类， 表示一个节点
class Boy{
    private int no; //编号
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }
}

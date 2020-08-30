package linkedlist;

public class SingleLinkedListDome {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
//        for(int i = 0; i < 100; i++) {
//            linkedList.add(new HeroNode(i, "", ""));
//        }
        linkedList.addByOrder(new HeroNode(100, "", ""));
        linkedList.addByOrder(new HeroNode(11, "", ""));

        linkedList.list();
        SingleLinkedList.reversetList(linkedList.getHead());
        System.out.println("反转:");
        linkedList.list();

    }
}


//定SingleLinkedList管理英雄
class SingleLinkedList {
    //县初始化一个头节点，头节点不动
    private HeroNode head = new HeroNode(0,"", "");

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next 指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }

        //当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    public HeroNode getHead() {
        return head;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动， 因此我们仍然能通过一个辅助指针（变量）来帮助我们找到添加的位置
        //因为单链表，因为我们找到temp是位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;  //添加的编号是否存在，默认为false
        while (true) {
            if(temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if(temp.next.no == heroNode.no) {  //说明系统添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next; //遍历当前链表
        }

        if(flag) { //不能添加，说明编号存在
            System.out.println("准备插入的英雄的编号%d 已经存在了，不能加入"+heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode) {
        if(head.next == null) {
            System.out.println("链表为空～");
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == newHeroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        //根据flag，判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;;
        } else {  //没有找到
            System.out.println("没有找到编号%d的节点， 不能修改");
        }
    }

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if(temp.next == null) { //已经到链表的最后
                break;
            }
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在");
        }
    }


    //显示链表[遍历]
    public void list() {
        //判断链表，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next移
            temp = temp.next;
        }
    }


    //查找单链表中的倒数第k个节点【新浪面试题】
    //思路
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index 表示是倒数第 index个节点
    //3.先把链表从头到尾遍历，得到链表的总的长度getLength
    //4.得到size后，我们从链表的第一个开始遍历(size - index) 个,就可以得到
    //5.如果找到了,则返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if(head.next == null) {
            return null; //没有找到
        }
        //第一次遍历链表的长度（节点的个数）
        int size = getLength(head);
        //先做一个index校验
        if(index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;
        for(int i = 0; i < (size - index); i++) {
            cur = cur.next;
        }
        return cur;
    }

    //方法:获取到单链表的节点的个数(如果是带头节点的链表，需求不统计头节点 )
    public static int getLength(HeroNode head) {
        if(head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //将单链表进行反转
    public static void  reversetList(HeroNode head) {
        //入股 当前链表为，获取只有一个节点，无法反转，直接返回
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reserseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next; //先暂时的保持当前节点的下一个节点
            cur.next = reserseHead.next; //将cur的下一个节点指向新的链表的最前端
            reserseHead.next = cur;
            cur = next;
        }
        //将head.next指向reverseHead.next,实现单链表反转
         head.next = reserseHead.next;
    }
}

//
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNickName) {
        no = hNo;
        name = hName;
        nickname = hNickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}


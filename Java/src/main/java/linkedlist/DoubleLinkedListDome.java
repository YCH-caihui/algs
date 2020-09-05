package linkedlist;

public class DoubleLinkedListDome {

    public static void main(String[] args) {

    }

    class DoubleLinkedList {
        //先初始化一个头节点，头节点不要动，不存放具体的数据
        public HeroNode2 head = new HeroNode2(0, "", "");

        //返回头节点
        public HeroNode2 getHead() {
            return head;
        }

        public void add(HeroNode2 heroNode) {
            //因为head节点不能动，因此我们需要一个辅助遍历temp
            HeroNode2 temp = head;
            //遍历链表，找到最后
            while(true) {
                //找到链表最后
                if(temp.next == null) {
                    break;
                }
                //如果没有找到最后，将temp后移
                temp = temp.next;
            }

            //当退出while循环时，temp就指向了链表的最后
            //将最后这个节点的next指向新的节点
            temp.next = heroNode;
            heroNode.pre = temp;
        }

        //修改节点的信息，根据no编号来修改，即no编号不能改
        public void update(HeroNode2 newHeroNode) {
            if(head.next == null) {
                System.out.println("链表为空～");
            }
            //找到需要修改的节点，根据no编号
            //定义一个辅助变量
            HeroNode2 temp = head.next;
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
                temp.nickName = newHeroNode.nickName;;
            } else {  //没有找到
                System.out.println("没有找到编号%d的节点， 不能修改");
            }
        }

        public void del(int no) {

            //判断当前链表是否为空
            if(head.next == null) {//空链表
                System.out.println("链表为空");
            }

            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true) {
                if(temp == null) { //已经到链表的最后
                    break;
                }
                if(temp.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //判断flag
            if(flag) {
                temp.pre.next = temp.next;
                if(temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("要删除的节点不存在");
            }
        }


        //遍历双向链表
        public void list() {
            //判断链表是否为空
            if(head.next == null) {
                System.out.println("链表为空");
                return;
            }
            //因为头节点，不能动，因此我们需要一个辅助变量来遍历
            HeroNode2 temp = head.next;
            while (true) {
                //判断是否到链表最后
                if(temp == null) {
                    break;
                }
                //输出节点信息
                System.out.println(temp);
                //将temp后移
                temp = temp.next;
            }
        }
    }

    class HeroNode2 {
        public int no;
        public String name;
        public String nickName;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "HeroNode2{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", next=" + next +
                    ", pre=" + pre +
                    '}';
        }
    }
}

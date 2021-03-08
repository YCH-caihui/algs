package linkedlist;

public class DoubleLinkedListDome {
    public static void main(String[] argc) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(new HeroNode2(2, "小明"));
        doubleLinkedList.addByOrder(new HeroNode2(10, "华哥"));
        doubleLinkedList.addByOrder(new HeroNode2(3, "张全蛋"));
        doubleLinkedList.addByOrder(new HeroNode2(5, "小辉"));
        doubleLinkedList.update(2, "哈哈");
        doubleLinkedList.update(123,"sdas");
        doubleLinkedList.dump();
    }
}


class HeroNode2 {
    int index;
    String name;
    HeroNode2 next;
    HeroNode2 pre;

    public HeroNode2(int index, String name) {
        this.index = index;
        this.name = name;
    }
}


class DoubleLinkedList {
    HeroNode2 mHeaderNode = new HeroNode2(-1, "");

    public void add(HeroNode2 node) {
        HeroNode2 temp = mHeaderNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addByOrder(HeroNode2 node) {
        HeroNode2 temp = mHeaderNode;
        boolean isCanAdd = true;
        while (temp.next != null) {
            if(temp.next.index > node.index) {
                break;
            }else if(temp.next.index == node.index) {
                isCanAdd = false;
                break;
            }
            temp = temp.next;
        }
        if(isCanAdd) {
            HeroNode2 markNode = temp.next;
            temp.next = node;
            node.pre = temp;
            node.next = markNode;
        }

    }


    public void delete(int index) {
        HeroNode2 temp = mHeaderNode;
        while (temp.next != null) {
            if(temp.next.index == index) {
                temp.next = temp.next.next;
                if(temp.next != null) {
                    temp.next.pre = temp;
                }

                System.out.println("找到并删除了");
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到");
    }

    public void update(int index, String name) {
        HeroNode2 temp = mHeaderNode;
        while (temp.next != null) {
            if(temp.next.index == index) {
                temp.next.name = name;
                System.out.println("找到并替换了");
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有找到");
    }


    public void dump() {
        HeroNode2 temp = mHeaderNode.next;
        while (temp != null) {
            System.out.println("index:"+temp.index +"  ==== name:"+temp.name);
            temp = temp.next;
        }
    }

}
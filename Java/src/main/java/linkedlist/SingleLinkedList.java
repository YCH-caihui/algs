package linkedlist;

class HeroNode {
    int index;
    String name;
    HeroNode next;

    HeroNode(int index ,String name) {
        this.name = name;
        this.index = index;
    }
}

public class SingleLinkedList {

    private HeroNode mHeaderNode = new HeroNode(-1,"");


    public void add(HeroNode node) {
        HeroNode temp = mHeaderNode;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }


    public void addByOrder(HeroNode node) {
        HeroNode temp = mHeaderNode;
        boolean isCanAdd = true;
        while (temp.next != null) {
            if(temp.next.index > node.index) {
                break;
            } else if(temp.next.index == node.index) {
                isCanAdd = false;
                break;
            }

            temp = temp.next;
        }
        if(isCanAdd) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.println("相同的不能添加");
        }

    }


    public void update(HeroNode heroNode) {
        HeroNode temp = mHeaderNode;
        boolean isFind = false;
        while (temp != null) {
            if(temp.index == heroNode.index) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }

        if(isFind) {
            temp.index = heroNode.index;
            temp.name = heroNode.name;
        } else {
            System.out.println("没有找到:index"+heroNode.index+"     name:"+heroNode.name);
        }
    }

    public void delete(int index) {
        HeroNode temp = mHeaderNode;
        boolean isFind = false;
        while (temp.next != null) {
            if(temp.next.index == index) {
                isFind = true;
                break;
            }
            temp = temp.next;
        }

        if(isFind) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到:"+index);
        }
    }

    public void reverse() {
        HeroNode reverseList = new HeroNode(0,"");
        HeroNode cur = mHeaderNode.next;
        HeroNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseList.next;
            reverseList.next = cur;
            cur = next;
        }
        mHeaderNode = reverseList;
    }

    public void dump() {
        HeroNode temp = mHeaderNode.next;
        while (temp != null) {
            System.out.println(temp.index+"============"+ temp.name);
            temp = temp.next;
        }
    }

}


 class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new HeroNode(1,"hahah"));
        singleLinkedList.add(new HeroNode(3,"heihei"));
        singleLinkedList.add(new HeroNode(2,"yes"));
        singleLinkedList.reverse();
        singleLinkedList.dump();
    }
}

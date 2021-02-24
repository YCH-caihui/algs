package linkedlist;

class HeroNode {
    String name;
    HeroNode next;

    HeroNode(String name) {
        this.name = name;
    }
}

public class SingleLinkedList {

    private HeroNode mHeaderNode = new HeroNode("");


    public void add(HeroNode node) {
        HeroNode temp = mHeaderNode;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void dump() {
        HeroNode temp = mHeaderNode.next;
        while (temp != null) {
            System.out.println(temp.name+"============");
            temp = temp.next;
        }
    }

}


 class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new HeroNode("hahah"));
        singleLinkedList.add(new HeroNode("heihei"));
        singleLinkedList.add(new HeroNode("yes"));
        singleLinkedList.dump();
    }
}

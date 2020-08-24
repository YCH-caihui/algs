package linkedlist;

public class SingleLinkedList {
    public static void main(String[] args) {

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
                ", next=" + next +
                '}';
    }
}


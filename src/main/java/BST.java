public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素E
    public void add(E e) {
//        if(root == null) {
//            root = new Node(e);
//            size ++;
//        } else
//            add(root, e);

        root = addNew(root, e);

    }

    //向以node为根的二分搜索树中插入元素E，递归算法
    private void add(Node node, E e){
        if(e.equals(node.e))  return;
        else if(e.compareTo(node.e) < 0 && node.left == null) {
            node.left  = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if(e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    private Node addNew(Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
            node.left = addNew(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = addNew(node.right, e);
        }

        return node;
    }

    //查看Node为根的二分搜索树中是否包含元素E
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
           return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历node为根的二分搜素树，递归算法
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }


    //二分搜索树中序遍历
    private void inOrder() {
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后续遍历
    public void postOrder() {
        postOrder(root);
    }

    //后续遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
         generateBSTString(root, 0, stringBuilder);
         return stringBuilder.toString();
    }

    //生成以node为根节点，深度为dept的描述二叉树字符串
    private void generateBSTString(Node node , int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2,100};
        for(int num : nums) {
            bst.add(num);
        }

//        bst.preOrder();
//        bst.inOrder();
         bst.postOrder();
//        System.out.println(bst);
    }
}

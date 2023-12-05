import com.sun.source.tree.Tree;

public class BinarySearchTree <T extends Comparable<T>>{
    private class Node {
        private Node left, right;
        private T data;
        public Node(T data) {
            left = null;
            right = null;
            this.data = data;
        }
    }
    private Node root;
    public BinarySearchTree() {
        root = null;
    }
    public void print(Node n) {
        print(n);
    }
   // public int getHeight(Node n) {
        // return height(root);
   // }
   /* private int height(Node n) {

    } */
   /* private void preFixPrint(Node n) {

    } */
   /* private int countLeafNodes(Node n) {

    }
    public int countNodes(Node n) {

    } */
   /* public void insert(Node n, int value) {

    } */
    /* public boolean search(Node n, int value) {

    } */
    public static void main(String[] args) {
       /* Tree T = new Tree(3);
        T.insert(1);
        T.printTree();
        T.insert(4);
        T.printTree();
        T.insert(6);
        T.printTree();
        T.insert(9);
        T.printTree();
        T.insert(2);
        T.printTree();
        T.insert(5);
        T.printTree();
        T.insert(7);
        T.printTree(); */
        /* System.out.println("Leaf Nodes: " + T.countLeafNodes(T.root));
        System.out.println("Total Nodes: " + T.countNodes(T.root));
        System.out.println("Height: " + T.height());
        System.out.println("Get Height: " + T.getHeight(T.root));
        System.out.println("Search: " + T.search(4));
        System.out.println("Search: " + T.search(2));
        System.out.println("Search: " + T.search(3));
        System.out.println("Search: " + T.search(8)); */
    }
}

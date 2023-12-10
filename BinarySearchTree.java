

public class BinarySearchTree <T extends Comparable<T>> {
    private static class Node {
        private Node left, right;
        private final int data;
        public Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }
    private Node root;
    public BinarySearchTree() {
        root = null;
    }
    /* public void print(Node n) {

    } */
   public int getHeight(Node root) {
        return height(root);
   }
   private int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            int leftDepth = height(n.left);
            int rightDepth = height(n.right);
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }
   /* public void preorder(Node root) {
       preorder(this.root);
    } */
   private void preFixPrint(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(root.data + " ");
        preFixPrint(n.left);
        preFixPrint(n.right);
    }
    public void printTree() {
       preFixPrint(root);
    }
    private int countLeafNodes(Node n) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        } else {
            return countLeafNodes(n.left) + countLeafNodes(n.right);
        }
    }
    public int countNodes(Node n) {
        if (n == null) {
            return 0;
        }
        int l = countNodes(n.left);
        int r = countNodes(n.right);
        return 1 + l + r;
    }
    public void insert(int value) {
       this.root = insert(root, value);
    }
   public Node insert(Node n, int value) {
    if (n == null) {
        n = new Node(value);
        return n;
    } else if (n.data >= value) {
        n.left = insert(n.left, value);
    } else {
        n.right = insert(n.right, value);
    }
    return n;
   }
    private boolean search(Node n, int value) {
    if (n == null) {
        return false;
    } else if (n.data == value) {
        return true;
    } else if (n.data > value) {
        return search(n.left, value);
    }
    return search(n.right, value);
    }
    public boolean search(int data) {
       return search(this.root, data);
    }
    public static void main(String[] args) {
       BinarySearchTree T = new BinarySearchTree();
        T.insert(3);
        T.printTree();
        T.preFixPrint(T.root);
        T.insert(1);
        T.printTree();
        T.preFixPrint(T.root.left);
        T.insert(4);
        T.printTree();
        T.preFixPrint(T.root.right);
        T.insert(6);
        T.printTree();
        T.preFixPrint(T.root.right.right);
        T.insert(9);
        T.printTree();
        T.preFixPrint(T.root.right.right.right);
        T.insert(2);
        T.printTree();
        T.preFixPrint(T.root.left.right);
        T.insert(5);
        T.printTree();
        T.preFixPrint(T.root.right.right.left);
        T.insert(7);
        T.printTree();
        T.preFixPrint(T.root.right.right.right.left);
        System.out.println();
        System.out.println("Leaf Nodes: " + T.countLeafNodes(T.root));
        System.out.println("Total Nodes: " + T.countNodes(T.root));
        System.out.println("Height: " + T.height(T.root));
        System.out.println("Get Height: " + T.getHeight(T.root));
        System.out.println("Search: " + T.search(4));
        System.out.println("Search: " + T.search(2));
        System.out.println("Search: " + T.search(3));
        System.out.println("Search: " + T.search(8));
    }
}

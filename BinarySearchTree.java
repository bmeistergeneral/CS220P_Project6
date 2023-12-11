

public class BinarySearchTree <T extends Comparable<T>> {
    private static class Node {
        private Node left, right;
        private int data;
        public Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }

        public int getData() {
            return data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
        public void setData(int data) {
            this.data = data;
        }
    }
    private Node root;
    public BinarySearchTree() {
        root = null;
    }
   public int getHeight(Node root) {
        return height(root);
   }

   // prints height of the tree from the root down to bottom leaf node.
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

    // prints the data in preorder traversal from root n.
   private void preFixPrint(Node n) {
        if (n == null) {
            return;
        }
        System.out.printf("%s ", n.data);
        preFixPrint(n.left);
        preFixPrint(n.right);
    }
    // counts the number of leaf nodes in the BST
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
    // counts the number of total nodes.
    public int countNodes(Node n) {
        if (n == null) {
            return 0;
        }
        int l = countNodes(n.left);
        int r = countNodes(n.right);
        return 1 + l + r;
    }
    // connector code for insert method below
    public void insert(int value) {
       this.root = insert(root, value);
    }
    // inserts each node in the binary search tree including the root
   public Node insert(Node n, int value) {
        // if tree is empty create a root node.
    if (n == null) {
        n = new Node(value);
        return n;
        // if the root data is greater than element data insert at left child
    } else if (n.data >= value) {
        n.setLeft(insert(n.left, value));
        // else insert ar right child.
    } else {
        n.setRight(insert(n.right, value));
    }
    return n;
   }
   // searches for a specific node in the binary search tree
    private boolean search(Node n, int value) {
    if (n == null) {
        return false;
        // if node data is equal to the search value, it's found
    } else if (n.getData() == value) {
        return true;
        // if it's greater than the search value, search left subtree of that node
    } else if (n.getData() > value) {
        return search(n.getLeft(), value);
    }
    // else search the right subtree of that node
    return search(n.getRight(), value);
    }
    // connector code for search method
    public boolean search(int data) {
       return search(this.root, data);
    }
    // Driver code
    public static void main(String[] args) {
       BinarySearchTree T = new BinarySearchTree();
        T.insert(3);
        T.preFixPrint(T.root);
        T.insert(1);
        T.preFixPrint(T.root.left);
        T.insert(4);
        T.preFixPrint(T.root.right);
        T.insert(6);
        T.preFixPrint(T.root.right.right);
        T.insert(9);
        T.preFixPrint(T.root.right.right.right);
        T.insert(2);
        T.preFixPrint(T.root.left.right);
        T.insert(5);
        T.preFixPrint(T.root.right.right.left);
        T.insert(7);
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

import java.io.IOException;
import java.util.Scanner;

class BST {
    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    void insert(int val) {
        root = insertRec(root, val);
    }

    Node insertRec(Node root, int val) {
        if(root == null) {
            root = new Node(val);

            return root;
        } else {
            if(val < root.value) {
                root.left = insertRec(root.left, val);
            } else {
                root.right = insertRec(root.right, val);
            }
            return root;
        }
    }

    void sort(Node root) {
        if(root != null) {
            sort(root.left);
            System.out.print(root.value + " ");
            sort(root.right);
        }
    }
}

public class BSTSort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Nodes in a Tree: ");
        int size = sc.nextInt();

        BST bst = new BST();

        for(int i = 0; i < size; i++) {
            System.out.println("Enter Node " + (i+1) + ": ");
            int temp = sc.nextInt();
            bst.insert(temp);
        }

        sc.close();

        System.out.println("Sorted List: \n");

        bst.sort(bst.root);
    }
}
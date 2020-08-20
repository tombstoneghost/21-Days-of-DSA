import java.io.IOException;
import java.util.Scanner;

class AVL {
    class Node {
        int value, height;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
            height = 1;
        }
    }

    Node root;

    AVL() {
        root = null;
    }

    int height(Node newNode) {
        if(newNode == null)
            return 0;
        
        return newNode.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node leftRotate(Node node) {
        Node temp1 = node.right;
        Node temp2 = temp1.left;
        
        temp1.left = node;
        node.right = temp2;

        node.height = max(height(node.left), height(node.right)) + 1;
        temp1.height = max(height(temp1.left), height(temp1.right)) + 1;

        return temp1;
    }

    Node rightRotate(Node node) {
        Node temp1 = node.left;
        Node temp2 = temp1.right;

        temp1.right = node;
        node.left = temp2;

        node.height = max(height(node.left), height(node.right)) + 1;
        temp1.height = max(height(temp1.left), height(temp1.right)) + 1;

        return temp1;
    }

    int getBalance(Node node) {
        if(node == null)
            return 0;

        return (height(node.left) - height(node.right));
    }

    Node insert(Node node, int val) {
        if(node == null)
            return (new Node(val));
        
        if(val < node.value) {
            node.left = insert(node.left, val);
        } else if(val > node.value) {
            node.right = insert(node.right, val);
        } else {
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if(balance > 1 && val < node.left.value) {
            return rightRotate(node);
        } else if(balance < -1 && val > node.right.value) {
            return leftRotate(node);
        } else if(balance > 1 && val > node.left.value) {
            node.left = leftRotate(node);
            return rightRotate(node);
        } else if(balance < -1 && val < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void sort(Node root) {
        if(root != null) {
            sort(root.left);
            System.out.print(root.value + " ");
            sort(root.right);
        }
    }
}

public class AVLSort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Nodes in a Tree: ");
        int size = sc.nextInt();

        AVL avl = new AVL();

        for(int i = 0; i < size; i++) {
            System.out.println("Enter Node " + (i+1) + ": ");
            int temp = sc.nextInt();
            avl.root = avl.insert(avl.root, temp);
        }

        sc.close();

        System.out.println("Sorted List: \n");

        avl.sort(avl.root);
    }
}
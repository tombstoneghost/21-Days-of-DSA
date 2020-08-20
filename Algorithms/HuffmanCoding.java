import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int data;
    char ch;

    Node left;
    Node right;
}

class NewComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.data - y.data;
    }
}

public class HuffmanCoding {
    static void printHuffmanCode(Node root, String str) {
        if(root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + "\t:\t" + str);
        
            return;
        }

        printHuffmanCode(root.left, str + "0");
        printHuffmanCode(root.right, str + "1");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Characters");
        int n = scanner.nextInt();

        char[] charArray = new char[n];
        int[] charFreq = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " Character: ");
            charArray[i] = scanner.next().charAt(0);

            System.out.println("Enter it's frequency: ");
            charFreq[i] = scanner.nextInt();
        }

        scanner.close();

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(n, new NewComparator());

        for(int i = 0; i < n; i++) {
            Node node = new Node();

            node.ch = charArray[i];
            node.data = charFreq[i];

            node.left = null;
            node.right = null;

            priorityQueue.add(node);
        }

        Node root = null;

        while(priorityQueue.size() > 1) {
            Node x = priorityQueue.peek();
            priorityQueue.poll();

            Node y = priorityQueue.peek();
            priorityQueue.poll();

            Node node = new Node();

            node.data = x.data + y.data;
            node.ch = '-';

            node.left = x;
            node.right = y;

            root = node;

            priorityQueue.add(node);
        }

        System.out.println("\nCharacter : HuffmanCode");

        printHuffmanCode(root, "");
    }
}
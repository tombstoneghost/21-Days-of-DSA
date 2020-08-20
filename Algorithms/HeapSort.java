import java.io.IOException;
import java.util.Scanner;

public class HeapSort {
    int[] array;
    int size;

    static Scanner sc = new Scanner(System.in);

    HeapSort(int size) {
        this.size = size;
        array = new int[size];
    }

    void input() throws IOException {
        for(int i = 0; i < size; i++) {
            System.out.println("Enter " + (i+1) + " Element");
            array[i] = sc.nextInt();
        }
    }

    void heapify(int root) {
        int largest = root;
        int left = 2 * root  + 1;
        int right = 2 * root + 2;

        if(left < size && array[left] > array[largest]) {
            largest = left;
        } if(right < size && array[right] > array[largest]) {
            largest = right;
        }

        if(largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
        
            heapify(largest);
        }
    }

    void sort() {
        for(int i = size/2 - 1; i >= 0; i--) 
            heapify(i);
        
        for(int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(0);
        }
    }

    void print() {
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter Size of Heap");
        int size = sc.nextInt();

        HeapSort heapSort = new HeapSort(size);
        heapSort.input();
        System.out.println("Input Array: ");
        heapSort.print();
        heapSort.sort();
        System.out.println("Sorted Array: ");
        heapSort.print();

    }
}
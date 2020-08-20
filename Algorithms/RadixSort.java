import java.util.*;

public class RadixSort {
    static int arr[];
    static int length;

    int getMax() {
        int max = arr[0];
        for(int i = 1; i < length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    void countingSort(int e) {
        int output[] = new int[length];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for(int i = 0; i < length; i++) {
            count[(arr[i]/e) % 10]++;
        }

        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for(int i = length - 1; i >= 0; i--) {
            output[count[(arr[i]/e) % 10] - 1] = arr[i];
            count[(arr[i]/e) % 10] --;
        }

        for(int i = 0; i < length; i++) {
            arr[i] = output[i];
        }
    }

    public void sort() {
        int max = getMax();

        for(int e = 1; max/e > 0; e *= 10) {
            countingSort(e);
        }
    }

    public void print() {
        System.out.println("Sorted Array is: ");
        for(int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        arr = new int[]{5, 1, 3, 8 , 2};
        length = arr.length;

        RadixSort radixSort = new RadixSort();
        radixSort.sort();
        radixSort.print();
    }
}
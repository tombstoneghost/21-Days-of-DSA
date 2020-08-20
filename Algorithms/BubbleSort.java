public class BubbleSort {
    static int arr[];
    static int length;

    public void sort() {
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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

        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sort();
        bubbleSort.print();
    }
}
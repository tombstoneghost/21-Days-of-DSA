public class SelectionSort {
    static int arr[];
    static int length;

    public void sort() {
        for(int i = 0; i < length - 1; i++) {
            int minIndex = i;

            for(int j = i + 1; j < length; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        SelectionSort selectionSort = new SelectionSort();

        selectionSort.sort();
        selectionSort.print();
    }
}
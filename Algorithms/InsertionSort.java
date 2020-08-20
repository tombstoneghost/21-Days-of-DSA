public class InsertionSort {
    static int arr[];
    static int length;

    public void sort() {
        for(int i = 1; i < length; i++) {
            int j, v = arr[i];

            for(j = i - 1; j >= 0; j--) {
                if(arr[j] <= v)
                    break;
                
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = v;
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

        InsertionSort insertionSort = new InsertionSort();

        insertionSort.sort();
        insertionSort.print();
    }
}
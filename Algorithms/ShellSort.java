public class ShellSort {
    static int arr[];
    static int length;

    public void sort() {
        for(int gap = length/2; gap > 0; gap /= 2) {
            for(int i = gap; i < length; i ++) {
                int temp = arr[i], j;

                for(j = i; j >= gap && arr[j - gap] > temp; j -=gap) {
                        arr[j] = arr[j - gap];
                }

                arr[j] = temp;
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

        ShellSort shellSort = new ShellSort();

        shellSort.sort();
        shellSort.print();
    }
}
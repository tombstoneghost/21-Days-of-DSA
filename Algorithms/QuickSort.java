public class QuickSort {
    int[] array;

    public int[] sort(int[] array) {
        this.array = array;

        quickSort(0, array.length - 1);

        return array;
    }

    public void swap(int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public void quickSort(int from, int to) {
        if(from >= to)
            return;
        
        int value = array[to];
        int counter = from;

        for(int i = from; i < to; i++) {
            if(array[i] < value) {
                swap(i, counter);
                counter++;
            }
        }

        swap(counter, to);
        quickSort(from, counter - 1);
        quickSort(counter + 1, to);
    }

    public void print() {
        System.out.println("Sorted Array is: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 3, 8 , 2};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        quickSort.print();
    }
}
public class MergeSort {
    static int[] arr; 

    private void split(int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;

            split(low, mid);
            split(mid + 1, high);

            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        int l = mid - low + 1;
        int r = high - mid;

        int t1[] = new int[l];
        int t2[] = new int[r];

        for(int i = 0; i < l; i++) {
            t1[i] = arr[low + i];
        }
        for(int j = 0; j < r; j++) {
            t2[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while(i < l && j < r) {
            if(t1[i] <= t2[j]) {
                arr[k] = t1[i];
                i++;
            } else {
                arr[k] = t2[j];
                j++;
            }
            k++;
        }

        while(i < l) {
            arr[k] = t1[i];
            i++;
            k++;
        }

        while(j < r) {
            arr[k] = t2[j];
            j++;
            k++;
        }
    }

    public void print() {
        System.out.println("Sorted Array is: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{5, 1, 3, 8 , 2};

        MergeSort mergeSort = new MergeSort();

        mergeSort.split(0, arr.length - 1);
        mergeSort.print();
    }
}
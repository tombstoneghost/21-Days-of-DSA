import java.io.IOException;
import java.util.Scanner;

public class SumOfSubsets {
    static boolean isSubsetSum(int[] set, int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        for(int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        for(int i = 1; i <= sum; i++) {
            for(int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];

                if(i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][n];
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Number of Elements in the Set");
        int n = scanner.nextInt();

        System.out.println("Enter Set Elements");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter Sum Required: ");
        int sum = scanner.nextInt();

        scanner.close();

        if(isSubsetSum(arr, n, sum) == true) {
            System.out.println("Found Subset for the given Sum");
        } else {
            System.out.println("No Subset found");
        }
    }
}
import java.io.IOException;
import java.util.Scanner;

public class MatrixChain {
    
    char name;

    void printParanthesis(int i, int j, int n, int[][] brakcet) {
        if(i == j) {
            System.out.print(name++);
            return;
        }

        System.out.print('(');

        printParanthesis(i, brakcet[j][i], n, brakcet);
        printParanthesis(brakcet[j][i] + 1, j, n, brakcet);

        System.out.print(')');
    }

    void matrixChain(int[] matrix, int n) {
        int[][] mat = new int[n][n];

        for(int L = 2; L < n; L++) {
            for(int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                mat[i][j] = Integer.MAX_VALUE;

                for(int k = i; k <= j - 1; k++) {
                    int q = mat[i][k] + mat[k + 1][j] + matrix[i - 1] * matrix[k] *matrix[j];

                    if(q < mat[i][j]) {
                        mat[i][j] = q;

                        mat[j][i] = k;
                    }
                }
            }
        }

        name = 'A';

        System.out.println("Optimal Solution:");
        printParanthesis(1, n - 1, n, mat);
        System.out.println("\nOptimal Cost: " + mat[1][n-1]);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Matrices");
        int n = scanner.nextInt();

        System.out.println("Enter the matrix orders");
        //Input: 40 20 30 10 30
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();
    
        MatrixChain matrixChain = new MatrixChain();

        matrixChain.matrixChain(arr, n);
    }
}
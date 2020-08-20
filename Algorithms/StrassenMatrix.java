import java.io.IOException;
import java.util.Scanner;

public class StrassenMatrix {

    int[][] multiplyMatrix(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if(n == 1) {
            C[0][0] = A[0][0] + B[0][0];
        } else {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];

            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
        
            split(A, A11, 0, 0);
            split(A, A12, 0, n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);

            split(B, B11, 0, 0);
            split(B, B12, 0, n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);

            int[][] M1 = multiplyMatrix(addition(A11, A22), addition(B11, B22));
            int[][] M2 = multiplyMatrix(addition(A21, A22), B11);
            int[][] M3 = multiplyMatrix(A11, subtract(B12, B22));
            int[][] M4 = multiplyMatrix(A22, subtract(B21, B11));
            int[][] M5 = multiplyMatrix(addition(A11, A12), B22);
            int[][] M6 = multiplyMatrix(subtract(A21, A11), addition(B11, B12));
            int[][] M7 = multiplyMatrix(subtract(A12, A22), addition(B21, B22));
        
            int[][] C11 = addition(subtract(addition(M1, M4), M5), M7);
            int[][] C12 = addition(M3, M5);
            int[][] C21 = addition(M2, M4);
            int[][] C22 = addition(subtract(addition(M1, M3), M2), M6);

            join(C11, C, 0, 0);
            join(C12, C, 0, n/2);
            join(C21, C, n/2, 0);
            join(C22, C, n/2, n/2);
        }

        return C;
    }

    int[][] addition(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    void split(int[][] P, int[][] Q, int p, int q) {
        for(int i1 = 0, i2 = p; i1 < Q.length; i1++, i2++) {
            for(int j1 = 0, j2 = q; j1 < Q.length; j1++, j2++) {
                Q[i1][j1] = P[i2][j2];
            }
        }
    }

    void join(int[][] P, int[][] Q, int p, int q) {
        for(int i1 = 0, i2 = p; i1 < P.length; i1++, i2++) {
            for(int j1 = 0, j2 = q; j1 < P.length; j1++, j2++) {
                Q[i2][j2] = P[i1][j1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Order of Matrix: ");
        int n = scanner.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        System.out.println("Enter Elements of Matrix A");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println();

        System.out.println("Enter Elements of Matrix B");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        StrassenMatrix strassenMatrix = new StrassenMatrix();

        int[][] C = strassenMatrix.multiplyMatrix(A, B);

        System.out.println("\n\nMatrix A: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n\nMatrix B: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n\nProduct of Matrix A and B: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
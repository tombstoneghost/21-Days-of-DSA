import java.io.IOException;
import java.util.Scanner;

public class NQueenProblem {
    int N;

    NQueenProblem(int N) {
        this.N = N;
    }

    boolean isSafe(int[][] board, int row, int col) {
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; i >=0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean NQUtil(int[][] board, int col) {
        if(col >= N) {
            return true;
        }

        for(int i = 0; i < N; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1;

                if(NQUtil(board, col + 1) == true) {
                    return true;
                }

                board[i][col] = 0;
            }
        }
        
        return false;
    }

    boolean solveNQ() {
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        if(NQUtil(board, 0) == false) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    void printSolution(int[][] board) {
        System.out.println("\n");

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Board Size");
        int N = scanner.nextInt();

        scanner.close();

        NQueenProblem nQueenProblem = new NQueenProblem(N);

        nQueenProblem.solveNQ();
    }
}
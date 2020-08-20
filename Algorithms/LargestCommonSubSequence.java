import java.io.IOException;
import java.util.Scanner;

public class LargestCommonSubSequence {
    int lcs(char[] X, char[] Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if(X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        return L[m][n];
    }

    int max(int a, int b) {
        return ((a > b) ? a : b);
    }

    public static void main(String[] args) throws IOException {
        LargestCommonSubSequence lSequence = new LargestCommonSubSequence();
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1st String");
        String s1 = scanner.nextLine();

        System.out.println("Enter 2nd String");
        String s2 = scanner.nextLine();

        scanner.close();

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();

        int result = lSequence.lcs(X, Y, X.length, Y.length);

        System.out.println("Result is: " + result);
    }
}
import java.io.IOException;
import java.util.Scanner;

public class FibonacciSeries {

    static void printFibonacci(int n) {
        int[] fib = new int[n + 2];

        fib[0] = 0;
        fib[1] = 1;

        System.out.print(fib[0] + " " + fib[1] + " ");

        for(int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            System.out.print(fib[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Number of elements to be printed.");
        int n = scanner.nextInt();

        scanner.close();

        if(n == 0) {
            System.out.println("Invalid Input");
        } else if(n == 1) {
            System.out.println("0");
        } else if(n == 2) {
            System.out.println("0 1");
        } else {
            printFibonacci(n);
        }
        System.out.println();
    }
}
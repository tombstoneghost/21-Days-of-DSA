import java.io.IOException;
import java.util.Scanner;

public class Knapsack {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSackSol(int maxWeight, int[] itemWeight, int[] itemVal, int n) {
        int[][] Sack = new int[n + 1][maxWeight + 1];

        for(int i = 0; i <= n; i++) {
            for(int w = 0; w <= maxWeight; w++) {
                if(i == 0 || w == 0) {
                    Sack[i][w] = 0;
                } else if(itemWeight[i - 1] <= w) {
                    Sack[i][w] = max(itemVal[i - 1] + Sack[i - 1][w - itemWeight[i - 1]], Sack[i - 1][w]);
                } else {
                    Sack[i][w] = Sack[i - 1][w];
                }
            }
        }
        return Sack[n][maxWeight];
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Maximum Weight");
        int weight = scanner.nextInt();

        System.out.println("Enter Number of Items");
        int numItems = scanner.nextInt();

        int[] itemWeight = new int[numItems];
        int[] itemProfit = new int[numItems];

        System.out.println();

        for(int i = 0; i < numItems; i++) {
            System.out.println("Enter Weight of Item No. " + (i+1) + ": ");
            itemWeight[i] = scanner.nextInt();

            System.out.println("Enter Profit on Item No. " + (i+1) + ": ");
            itemProfit[i] = scanner.nextInt();
        }

        scanner.close();

        int totalProfit = knapSackSol(weight, itemWeight, itemProfit, numItems);
    
        System.out.println("Total Profit is: " + totalProfit);
    } 
}
import java.io.IOException;
import java.util.Scanner;

public class FractionalKnapsack {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Maximum Weight");
        double weight = scanner.nextInt();

        System.out.println("Enter Number of Items");
        int numItems = scanner.nextInt();

        double[] itemWeight = new double[numItems];
        double[] itemProfit = new double[numItems];
        double[] profitPerItem = new double[numItems];

        System.out.println();

        for(int i = 0; i < numItems; i++) {
            System.out.println("Enter Weight of Item No. " + (i+1) + ": ");
            itemWeight[i] = scanner.nextInt();

            System.out.println("Enter Profit on Item No. " + (i+1) + ": ");
            itemProfit[i] = scanner.nextInt();

            profitPerItem[i] = itemProfit[i]/itemWeight[i];
        } 
        
        //The Complexity of this Algorithm can be increased by using quickSort
        //Below I am Implemented Bubble Sort
        for(int i = 0; i < numItems; i++) {
            for(int j = 0; j < numItems - 1; j++) {
                if(profitPerItem[j] > profitPerItem[j + 1]) {
                    double temp = profitPerItem[j];
                    profitPerItem[j] = profitPerItem[j + 1];
                    profitPerItem[j + 1] = temp;

                    temp = itemWeight[j];
                    itemWeight[j] = itemWeight[j + 1];
                    itemWeight[j + 1] = temp;

                    temp = itemProfit[j];
                    itemProfit[j] = itemProfit[j + 1];
                    itemProfit[j + 1] = temp;
                }
            }
        }

        double totalWeight = 0;
        double totalProfit = 0;

        for(int i = numItems - 1; i >= 0; i--) {
            if((totalWeight + itemWeight[i]) < weight) {
                totalProfit += itemProfit[i];
                totalWeight += itemWeight[i];
            } else {
                if(totalWeight == weight) {
                    break;
                } else {
                    totalProfit += ((weight - totalWeight)/itemWeight[i]) * profitPerItem[i];
                    totalWeight += (weight - totalWeight)/itemWeight[i];
                }
            }
        }
        
        System.out.println("Total Profit is: " + totalProfit);

        scanner.close();
    }
}
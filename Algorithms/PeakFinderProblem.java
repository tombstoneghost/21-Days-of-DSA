import java.io.IOException;
import java.util.Scanner;

class PeakFinder {
    int[] array1D;
    int size;

    int[][] array2D; 
    int row, col;

    boolean k = false;

    Scanner sc = new Scanner(System.in);

    PeakFinder(int size) {
        this.size = size;
        array1D = new int[size];
        
        array2D = null;
        this.row = this.col = 0;
    }

    PeakFinder(int row, int col) {
        this.row = row;
        this.col = col;
        array2D = new int[row][col];

        k = true;

        array1D = null;
        this.size = 0;
    }

    void input() throws IOException{
        if(k) {
            int count = 1;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    System.out.println("Enter " + count + " Element: ");
                    array2D[i][j] = sc.nextInt();
                    count++;
                }
            }
        } else {
            for(int i = 0; i < size; i++) {
                System.out.println("Enter " + (i + 1) + " Element: ");
                array1D[i] = sc.nextInt();
            }
        }
    }

    int max(int column) {
        int maximum = 0;

        for(int i = 0; i < row; i++) {
            if(array2D[i][column] > maximum) {
                maximum = i;
            }
        }

        return maximum;
    }

    int peakFinderSolRec(int mid) {
        if(k) {
            int maxIndex = max(mid);
            int maximum = array2D[maxIndex][mid];

            if(mid == 0 || mid - col == 1) {
                return maximum;
            } else if (maximum >= array2D[maxIndex][mid - 1] && maximum >= array2D[maxIndex][mid + 1]) {
                return maximum;
            } else if(maximum < array2D[maxIndex][mid]) {
                return peakFinderSolRec((int)(mid - Math.ceil((double)mid/2)));
            } else {
                return peakFinderSolRec((int)(mid + Math.ceil((double)mid/2)));
            }
        } else {
            int maximum = array1D[mid];

            if(maximum < array1D[mid - 1]) {
                return peakFinderSolRec((int)(mid - Math.ceil((double)mid/2)));
            } else if(maximum < array1D[mid + 1]) {
                return peakFinderSolRec((int)(mid + Math.ceil((double)mid/2)));
            } else {
                return maximum;
            }
        }
    }

    int peakFinderSol() {
        if(k) {
            return peakFinderSolRec(col/2);
        } else {
            return peakFinderSolRec(size/2);
        }
    }

    void print() {
        if(k) {
            System.out.println("\n");
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    System.out.print(array2D[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for(int i = 0; i < size; i++) {
                System.out.print(array1D[i] + " ");
            }
        }
    }
}

public class PeakFinderProblem {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of 1D Array");
        int size = sc.nextInt();
    
        PeakFinder peakFinder1D = new PeakFinder(size);
        peakFinder1D.input();
        System.out.println("\n" + "Peak Value is: " + peakFinder1D.peakFinderSol() + "\n");
        peakFinder1D.print();
        System.out.println();

        System.out.println("Enter Row Size of 2D Array");
        int row = sc.nextInt();
        System.out.println("Enter Column Size of 2D Array");
        int col = sc.nextInt();

        PeakFinder peakFinder2D = new PeakFinder(row, col);
        peakFinder2D.input();
        System.out.println("\n" + "Peak Value is: " + peakFinder1D.peakFinderSol() + "\n");
        peakFinder2D.print();
        System.out.println();

        sc.close();
    }
}
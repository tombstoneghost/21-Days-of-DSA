import java.io.IOException;
import java.util.Scanner;

public class HamiltonianCycle {
    int vertices;
    int[] path;

    HamiltonianCycle(int vertices) {
        this.vertices = vertices;
    }

    boolean isSafe(int vertix, int[][] graph, int[] path, int position) {
        if(graph[path[position - 1]][vertix] == 0) {
            return false;
        }

        for(int i = 0; i < position; i++) {
            if(path[i] == vertix) {
                return false;
            }
        }

        return true;
    }

    boolean hamiltonianCycleUtil(int[][] graph, int[] path, int position) {
        if(position == vertices) {
            if(graph[path[position - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        for(int i = 1; i < vertices; i++) {
            if(isSafe(i, graph, path, position)) {
                path[position] = i;

                if(hamiltonianCycleUtil(graph, path, position + 1) == true) {
                    return true;
                }
                path[position] = -1;
            }
        }
        return false;
    }

    int HamiltonianCycleSol(int[][] graph) {
        path = new int[vertices];

        for(int i = 0; i < vertices; i++) {
            path[i] = -1;
        }

        path[0] = 0;

        if(hamiltonianCycleUtil(graph, path, 1) == false) {
            System.out.println("Solution does not exist");
            return 0;
        }

        printSolution(path);
        
        return 1;
    }

    void printSolution(int[] path) {
        System.out.println("Solution: \n");

        for(int i = 0; i < vertices; i++) {
            System.out.print(" " + path[i] + " ");
        }

        System.out.print(" " + path[0] + " ");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter No. of Vertices");
        int vertices = scanner.nextInt();

        HamiltonianCycle hCycle = new HamiltonianCycle(vertices);

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter Graph Elements");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        hCycle.HamiltonianCycleSol(graph);
    }
}
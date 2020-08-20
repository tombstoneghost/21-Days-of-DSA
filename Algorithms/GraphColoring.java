import java.io.IOException;
import java.util.Scanner;

public class GraphColoring {
    int[] color;
    int vertices;

    GraphColoring(int vertices) {
        this.vertices = vertices;
    }

    boolean isSafe(int vertix, int[][] graph, int[] color, int c) {
        for(int i = 0; i < vertices; i++) {
            if(graph[vertix][i] == 1 && c == color[i]) {
                return false;
            }
        }

        return true;
    }

    boolean GraphColoringUtil(int[][] graph, int m, int[] color, int vertix) {
        if(vertix == vertices) {
            return true;
        }

        for(int i = 1; i <= m; i++) {
            if(isSafe(vertix, graph, color, i)) {
                color[vertix] = i;
            
                if(GraphColoringUtil(graph, m, color, vertix + 1)) {
                    return true;
                }

                color[vertix] = 0;
            }
        }

        return false;
    }

    boolean GraphColoringSol(int[][] graph, int m) {
        color = new int[vertices];

        for(int i = 0; i < vertices; i++) {
            color[i] = 0;
        }

        if(GraphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(color);

        return true;
    }

    void printSolution(int[] color) {
        System.out.println("Solution: ");

        for(int i = 0; i < vertices; i++) {
            System.out.println(" " + color[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Vertices");
        int V = scanner.nextInt();

        GraphColoring gColoring = new GraphColoring(V);

        int[][] graph = new int[V][V];

        System.out.println("Enter Graph Values");

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        int m = 3;

        gColoring.GraphColoringSol(graph, m);
    }
}
import java.io.IOException;
import java.util.Scanner;

public class PrimsMST {
    int vertices;
    
    int minimumEdge(int[] edges, Boolean[] mst) {
        int minimum = Integer.MAX_VALUE;
        int minimumIndex = -1;

        for(int i = 0; i < vertices; i++) {
            if(mst[i] == false && edges[i] < minimum) {
                minimum = edges[i];
                minimumIndex = i;
            }
        }

        return minimumIndex;
    }

    void print(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");

        for(int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    void prims(int[][] graph) {
        int[] parent = new int[vertices];
        int[] edges = new int[vertices];
        Boolean[] mst = new Boolean[vertices];

        for(int i = 0; i < vertices; i++) {
            edges[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }

        edges[0] = 0;
        parent[0] = -1;

        for(int i = 0; i < vertices - 1; i++) {
            int temp = minimumEdge(edges, mst);

            mst[temp] = true;
        
            for(int j = 0; j < vertices; j++) {
                if(graph[temp][j] != 0 && mst[j] == false && graph[temp][j] < edges[j]) {
                    parent[j] = temp;
                    edges[j] = graph[temp][j];
                }
            }
        }

        print(parent, graph);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        PrimsMST pMst = new PrimsMST();

        System.out.println("Enter the number of Vertices: ");
        pMst.vertices = scanner.nextInt();

        int[][] graph = new int[pMst.vertices][pMst.vertices];

        System.out.println("Enter Graph Elements: ");
        for(int i = 0; i < pMst.vertices; i++) {
            for(int j = 0; j < pMst.vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        pMst.prims(graph);
    }
}
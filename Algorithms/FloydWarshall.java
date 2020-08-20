import java.io.IOException;
import java.util.Scanner;

public class FloydWarshall {
    final static int INF = 999999;

    int vertices;

    FloydWarshall(int vertices) {
        this.vertices = vertices;
    }

    void floydWarshall(int[][] graph) {
        int[][] distance = new int[vertices][vertices];

        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        for(int k = 0; k < vertices; k++) {
            for(int i = 0; i < vertices; i++) {
                for(int j = 0; j < vertices; j++) {
                    if(distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }   
        }

        print(distance);
    }

    void print(int[][] graph) {
        System.out.println("Shortest Paths between every pair of verticies\n");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                if(graph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Vertices");
        int vertices = scanner.nextInt();

        FloydWarshall fWarshall = new FloydWarshall(vertices);

        System.out.println("Enter the Graph Values.\nNote: Enter 999999 for Infinite Value");

        int[][] graph = new int[vertices][vertices];

        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        fWarshall.floydWarshall(graph);
    }
}
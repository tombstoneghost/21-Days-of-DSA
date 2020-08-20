import java.io.IOException;
import java.util.Scanner;

public class DijkstraShortestPath {
    int[][] graph;
    int verticies;

    static Scanner scanner = new Scanner(System.in);

    DijkstraShortestPath(int verticies) {
        this.verticies = verticies;
        graph = new int[verticies][verticies];
    }
    
    void input() throws IOException{
        System.out.println("Enter the Adjacency Matrix");
        for(int i = 0; i < verticies; i++) {
            for(int j = 0; j < verticies; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
    }

    void print() {
        for(int i = 0; i < verticies; i++) {
            for(int j = 0; j < verticies; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    void dijkstra(int source) {
        int totalVertix = graph.length;
        boolean[] visitedVertix = new boolean[totalVertix];
        int[] distance = new int[totalVertix];

        for(int i = 0; i < totalVertix; i++) {
            visitedVertix[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        for(int i = 0; i < totalVertix; i++) {
            int d = minimumDistance(distance, visitedVertix);

            visitedVertix[d] = true;

            for(int v = 0; v < totalVertix; v++) {
                if(!visitedVertix[v] && graph[d][v] != 0 && (distance[d] + graph[d][v] < distance[v])) {
                    distance[v] = distance[d] + graph[d][v];
                }
            }
        }

        for(int i = 0; i < distance.length; i++) {
            System.out.println("Distance from vertix " + source + " to " + i + " is: " + distance[i]);
        }
    }

    int minimumDistance(int[] distance, boolean[] visitedVertix) {
        int minimum = Integer.MAX_VALUE;
        int minVertix = -1;

        for(int i = 0; i < distance.length; i++) {
            if(!visitedVertix[i] && distance[i] < minimum) {
                minimum = distance[i];
                minVertix = i;
            }
        }

        return minVertix;
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Enter Number of Verticies: ");
        int verticies = scanner.nextInt();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(verticies);

        dijkstraShortestPath.input();
        dijkstraShortestPath.print();
        dijkstraShortestPath.dijkstra(0);
    }
}
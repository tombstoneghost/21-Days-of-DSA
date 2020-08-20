import java.io.IOException;
import java.util.Scanner;

public class TravellingSalesman {
    static int tsp(int[][] graph, boolean[] visited, int currentPosition, int vertices, int count, int cost, int answer) {
        if(count == vertices && graph[currentPosition][0] > 0) {
            answer = Math.min(answer, cost + graph[currentPosition][0]);
            return answer;
        } 

        for(int i = 0; i < vertices; i++) {
            if(visited[i] == false && graph[currentPosition][i] > 0) {
                visited[i] = true;

                answer = tsp(graph, visited, i, vertices, count + 1, cost + graph[currentPosition][i], answer);

                visited[i] = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Verticies: ");
        int vertices = scanner.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter Graph Values");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        boolean[] visited = new boolean[vertices];
        visited[0] = true;

        int answer = Integer.MAX_VALUE;

        answer = tsp(graph, visited, 0, vertices, 1, 0, answer);

        System.out.println("Minimum Value is: " + answer);

        scanner.close();
    }
}
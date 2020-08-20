import java.io.IOException;
import java.util.Scanner;

public class BellmanFordAlgorithm {
    class Edge {
        int source, destination, weight;
        
        Edge() {
            this.source = 0;
            this.destination = 0;
            this.weight = 0;
        }
    }
    
    int verticies, edges;
    Edge edge[];

    BellmanFordAlgorithm(int verticies, int edges) {
        this.verticies = verticies;
        this.edges = edges;

        edge = new Edge[edges];

        for(int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }

    void bellmanFord(BellmanFordAlgorithm graph, int source) {
        int verticies = graph.verticies;
        int edges = graph.edges;

        int[] distance = new int[verticies];

        for(int i = 0; i < verticies; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        for(int i = 1; i < verticies; i++) {
            for(int j = 0; j < edges; j++) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int w = graph.edge[j].weight;

                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        for(int i = 0; i < edges; i++) {
            int u = graph.edge[i].source;
            int v = graph.edge[i].destination;
            int w = graph.edge[i].weight;

            if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph Contains Negative Cycle");
                return;
            }
        }

        print(distance, verticies);
    }

    void print(int[] distance, int verticies) {
        System.out.println("Vertex Distance from Source");
        for(int i = 0; i < verticies; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Vertices");
        int verticies = scanner.nextInt();

        System.out.println("Enter Number of Edges");
        int edges = scanner.nextInt();

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm(verticies, edges);

        int src, dest, weight;

        for(int i = 0; i < edges; i++) {
            System.out.println("Enter Details for Edge " + (i + 1) + ":-");
            
            System.out.println("Enter Source: ");
            src = scanner.nextInt();
            System.out.println("Enter Destination: ");
            dest = scanner.nextInt();
            System.out.println("Enter Weight: ");
            weight = scanner.nextInt();
            
            bellmanFordAlgorithm.edge[i].source = src;
            bellmanFordAlgorithm.edge[i].destination = dest;
            bellmanFordAlgorithm.edge[i].weight = weight;
        }

        scanner.close();

        bellmanFordAlgorithm.bellmanFord(bellmanFordAlgorithm, 0);
    }
}
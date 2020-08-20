import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KruskalsMST {
    class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public int compareTo(Edge edge) {
            return (this.weight - edge.weight);
        }
    }

    class subset {
        int parent, rank;
    }

    int vertices, edges;
    Edge edge[];

    KruskalsMST(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;

        edge = new Edge[edges];

        for(int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }

    int find(subset subsets[], int i) {
        if(subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    void union(subset subsets[], int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if(subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if(subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    void mst() {
        Edge[] rEdges = new Edge[vertices];
        int e = 0;

        for(int i = 0; i < vertices; i++) {
            rEdges[i] = new Edge();
        }

        Arrays.sort(edge);

        subset[] subsets = new subset[vertices];

        for(int i = 0; i < vertices; i++) {
            subsets[i] = new subset();
        }

        for(int i = 0; i < vertices; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i = 0;

        while(e < (vertices - 1)) {
            Edge nEdge = new Edge();
            nEdge = edge[i++];

            int x = find(subsets, nEdge.source);
            int y = find(subsets, nEdge.destination);

            if(x != y) {
                rEdges[e++] = nEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("\nEdges Constructed in MST: ");
        for(i = 0; i < e; i++) {
            System.out.println(rEdges[i].source + " - " + rEdges[i].destination + " = " + rEdges[i].weight);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int vertices, edges;
        
        System.out.println("Enter Number of Vertices: ");
        vertices = scanner.nextInt();

        System.out.println("Enter Number of Edges: ");
        edges = scanner.nextInt();

        KruskalsMST kMst = new KruskalsMST(vertices, edges);

        System.out.println("Enter Edge Data\n");

        for(int i = 0; i < edges; i++) {
            System.out.println("Enter Source of Edge " + (i+1) + ": ");
            kMst.edge[i].source = scanner.nextInt();

            System.out.println("Enter Destination of Edge " + (i+1) + ": ");
            kMst.edge[i].destination = scanner.nextInt();

            System.out.println("Enter Weight of Edge " + (i+1) + ": ");
            kMst.edge[i].weight = scanner.nextInt();
        }

        scanner.close();

        kMst.mst();
    }
}
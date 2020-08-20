import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
    int vertices;
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    DepthFirstSearch(int vertices) {
        this.vertices = vertices;
        adj = (LinkedList []) new LinkedList[vertices];

        for(int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int vertix, int value) {
        adj[vertix].add(value);
    }

    void DFS(int vertix, boolean visited[]) {
        visited[vertix] = true;
        System.out.print(vertix + " ");

        Iterator<Integer> iterator = adj[vertix].listIterator();
        while(iterator.hasNext()) {
            int temp = iterator.next();
            if(!visited[temp]) {
                DFS(temp, visited);
            }
        }
    }

    void search(int startVertix) {
        boolean visited[] = new boolean[this.vertices];

        DFS(startVertix, visited);
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("Starting from Vertix 2\n");

        dfs.search(2);

        System.out.println("\n");
    }
}
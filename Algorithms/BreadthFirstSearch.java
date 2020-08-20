import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {
    int vertices;
    LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    BreadthFirstSearch(int vertices) {
        this.vertices = vertices;
        adj = (LinkedList []) new LinkedList[vertices];

        for(int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int vertix, int value) {
        adj[vertix].add(value);
    }

    void search(int startVertix) {
        boolean visited[] = new boolean[this.vertices];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startVertix] = true;
        queue.add(startVertix);

        while(queue.size() != 0) {
            startVertix = queue.poll();
            System.out.print(startVertix + " ");

            Iterator<Integer> iterator = adj[startVertix].listIterator();
            while(iterator.hasNext()) {
                int num = iterator.next();
                if(!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        System.out.println("Starting from Vertix 2\n");

        bfs.search(2);

        System.out.println("\n");
    }
}
import java.util.*;

public class BFS {

    public Map<Integer, List<Integer>> graph;

    public BFS() {
        // adjacency list representation of graph
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        // ensure list exists for node u
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }

        // add directed edge u -> v
        graph.get(u).add(v);
    }

    public void bfs(int start) {
        // Intuition:
        // BFS explores level by level (like ripple in water)
        // Use queue → process current node → push its neighbours

        Set<Integer> visited = new HashSet<>(); // to avoid revisiting nodes
        Queue<Integer> queue  = new LinkedList<>();

        // start from given node
        queue.add(start);
        visited.add(start);

        List<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty())
        {
            // take current node from front (FIFO)
            int node = queue.poll();
            answer.add(node); // record traversal order

            // explore all neighbours of current node
            for(int neighbour:graph.get(node))
            {
                // only process unvisited nodes
                if(!visited.contains(neighbour))
                {
                    visited.add(neighbour); // mark visited early to avoid duplicates
                    queue.add(neighbour);   // push into queue for future processing
                }
            }
        }

        // print BFS traversal
        for(int num:answer)
        {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        BFS obj = new BFS();

        // build graph (directed edges)
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 8);

        // perform BFS starting from node 1
        graph.bfs(1);

        // call bfs
    }
}
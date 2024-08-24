

	import java.util.*;

	public class BFS {
	    private final int vertices;  // Number of vertices
	    private final List<List<Integer>> adjList;  // Adjacency list representation

	    // Constructor to initialize the graph
	    public BFS (int vertices) {
	        this.vertices = vertices;
	        adjList = new ArrayList<>(vertices);

	        // Initialize each vertex's adjacency list
	        for (int i = 0; i < vertices; i++) {
	            adjList.add(new LinkedList<>());  // Use LinkedList for each adjacency list
	        }
	    }

	    // Method to add an edge to the graph (undirected)
	    public void addEdge(int src, int dest) {
	        adjList.get(src).add(dest);  // Add edge from source to destination
	        adjList.get(dest).add(src);  // For undirected graph, also add edge from destination to source
	    }

	    // Method to perform Breadth-First Search (BFS)
	    public void bfs(int start) {
	        boolean[] visited = new boolean[vertices];  // Array to keep track of visited nodes
	        Queue<Integer> queue = new LinkedList<>();  // Queue for BFS
	        
	        visited[start] = true;  // Mark the start node as visited
	        queue.add(start);  // Add the start node to the queue
	        
	        System.out.print("BFS starting from vertex " + start + ": ");
	        
	        while (!queue.isEmpty()) {
	            int vertex = queue.poll();  // Remove and return the front node of the queue
	            System.out.print(vertex + " ");  // Process the current node
	            
	            // Get all adjacent vertices of the dequeued node
	            for (Integer neighbor : adjList.get(vertex)) {
	                if (!visited[neighbor]) {  // If the neighbor hasn't been visited
	                    visited[neighbor] = true;  // Mark it as visited
	                    queue.add(neighbor);  // Add the neighbor to the queue
	                }
	            }
	        }
	        System.out.println();
	    }

	    // Main method to demonstrate BFS
	    public static void main(String[] args) {
	    	BFS  graph = new BFS (6);  // Create a graph with 6 vertices

	        // Add edges to the graph
	        graph.addEdge(0, 1);
	        graph.addEdge(0, 4);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 3);
	        graph.addEdge(3, 4);
	        graph.addEdge(4, 5);

	        // Perform BFS from different start vertices
	        graph.bfs(0);  // Start BFS from vertex 0
	        graph.bfs(3);  // Start BFS from vertex 3
	    }
	}




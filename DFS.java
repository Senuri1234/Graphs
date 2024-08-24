
	
	import java.util.*;

	public class DFS {
	    private final int vertices;  // Number of vertices
	    private final List<List<Integer>> adjList;  // Adjacency list representation

	    // Constructor to initialize the dfs graph
	    public DFS(int vertices) {
	        this.vertices = vertices;
	        adjList = new ArrayList<>(vertices);

	        // Initialize each vertex's adjacency list
	        for (int i = 0; i < vertices; i++) {
	            adjList.add(new LinkedList<>());  // Use LinkedList for each adjacency list
	        }
	    }

	    // Method to add a dfs edge to the graph
	    public void addEdge(int src, int dest) {
	        adjList.get(src).add(dest);  // Add edge from source to destination
	    }

	    // Method to perform Depth-First Search (DFS) using recursion
	    public void dfsRecursive(int start) {
	        boolean[] visited = new boolean[vertices];  // Array to keep track of visited nodes
	        System.out.print("DFS (recursive) starting from vertex " + start + ": ");
	        dfsRecursiveUtil(start, visited);
	        System.out.println();
	    }

	    // Utility method for DFS (recursive)
	    private void dfsRecursiveUtil(int vertex, boolean[] visited) {
	        visited[vertex] = true;  // Mark the current node as visited
	        System.out.print(vertex + " ");  // Process the current node

	        // Recur for all the vertices adjacent to this vertex
	        for (Integer neighbor : adjList.get(vertex)) {
	            if (!visited[neighbor]) {
	                dfsRecursiveUtil(neighbor, visited);
	            }
	        }
	    }

	    // Method to perform Depth-First Search (DFS) using iteration
	    public void dfsIterative(int start) {
	        boolean[] visited = new boolean[vertices];  // Array to keep track of visited nodes
	        Stack<Integer> stack = new Stack<>();  // Stack for DFS
	        
	        stack.push(start);  // Push the start node onto the stack
	        
	        System.out.print("DFS (iterative) starting from vertex " + start + ": ");
	        
	        while (!stack.isEmpty()) {
	            int vertex = stack.pop();  // Pop a vertex from the stack
	            
	            if (!visited[vertex]) {  // If the vertex has not been visited
	                visited[vertex] = true;  // Mark it as visited
	                System.out.print(vertex + " ");  // Process the vertex
	                
	                // Push all the adjacent vertices of the popped vertex to the stack
	                for (Integer neighbor : adjList.get(vertex)) {
	                    if (!visited[neighbor]) {
	                        stack.push(neighbor);
	                    }
	                }
	            }
	        }
	        System.out.println();
	    }

	    // Main method to demonstrate DFS
	    public static void main(String[] args) {
	    	DFS graph = new DFS(6);  // Create a dfs graph with 6 vertices

	        // Add directed edges to the graph
	        graph.addEdge(0, 1);
	        graph.addEdge(0, 4);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 3);
	        graph.addEdge(3, 4);
	        graph.addEdge(4, 5);

	        // Perform DFS (recursive and iterative) from different start vertices
	        graph.dfsRecursive(0);  // Start DFS (recursive) from vertex 0
	        graph.dfsIterative(0);  // Start DFS (iterative) from vertex 0

	        graph.dfsRecursive(3);  // Start DFS (recursive) from vertex 3
	        graph.dfsIterative(3);  // Start DFS (iterative) from vertex 3
	    }
	}




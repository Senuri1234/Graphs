

	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.List;

	public class Adjacency_list {
	    private final int vertices;            // Number of vertices in the graph
	    private final List<List<Integer>> adjList;  // Adjacency list representation
	    private final boolean directed;        // Whether the graph is directed or undirected

	    // Constructor to initialize the graph
	    public Adjacency_list(int vertices, boolean directed) {
	        this.vertices = vertices;
	        this.directed = directed;
	        adjList = new ArrayList<>(vertices);  // Initialize the adjacency list

	        // Initialize each vertex's adjacency list
	        for (int i = 0; i < vertices; i++) {
	            adjList.add(new LinkedList<>());  // Use LinkedList for each adjacency list
	        }
	    }

	    // Method to add an edge to the graph
	    public void addEdge(int src, int dest) {
	        adjList.get(src).add(dest);  // Add edge from source to destination
	        if (!directed) {
	            adjList.get(dest).add(src);  // For undirected graph, add edge from destination to source
	        }
	    }

	    // Method to remove an edge from the graph
	    public void removeEdge(int src, int dest) {
	        adjList.get(src).remove((Integer) dest);  // Remove edge from source to destination
	        if (!directed) {
	            adjList.get(dest).remove((Integer) src);  // For undirected graph, remove edge from destination to source
	        }
	    }

	    // Method to print the adjacency list of the graph
	    public void printGraph() {
	        for (int i = 0; i < vertices; i++) {
	            System.out.print("Vertex " + i + ":");
	            for (Integer vertex : adjList.get(i)) {
	                System.out.print(" -> " + vertex);
	            }
	            System.out.println();
	        }
	    }

	    // Main method to demonstrate graph creation and functionalities
	    public static void main(String[] args) {
	        // Create a directed graph with 5 vertices
	    	Adjacency_list directedGraph = new Adjacency_list(5, true);
	        directedGraph.addEdge(0, 1);
	        directedGraph.addEdge(0, 4);
	        directedGraph.addEdge(1, 2);
	        directedGraph.addEdge(1, 3);
	        directedGraph.addEdge(2, 3);
	        directedGraph.addEdge(3, 4);

	        System.out.println("Directed Graph:");
	        directedGraph.printGraph();

	        // Create an undirected graph with 5 vertices
	        Adjacency_list undirectedGraph = new Adjacency_list(5, false);
	        undirectedGraph.addEdge(0, 1);
	        undirectedGraph.addEdge(0, 4);
	        undirectedGraph.addEdge(1, 2);
	        undirectedGraph.addEdge(1, 3);
	        undirectedGraph.addEdge(2, 3);
	        undirectedGraph.addEdge(3, 4);

	        System.out.println("\nUndirected Graph:");
	        undirectedGraph.printGraph();

	        // Remove an edge from the undirected graph and print the updated graph
	        System.out.println("\nUndirected Graph after removing edge between 1 and 4:");
	        undirectedGraph.removeEdge(1, 4);
	        undirectedGraph.printGraph();
	    }
	}



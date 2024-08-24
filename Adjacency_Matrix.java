

	
	import java.util.ArrayList;
	import java.util.List;

	public class Adjacency_Matrix {
	    private final int vertices;          // Number of vertices in the graph
	    private final int[][] adjMatrix;     // Adjacency matrix to store edges

	    // Constructor to initialize the graph
	    public Adjacency_Matrix (int vertices) {
	        this.vertices = vertices;
	        adjMatrix = new int[vertices][vertices]; // Initialize adjacency matrix with zeros
	    }

	    // Method to add an edge to the graph (for directed graph)
	    public void addEdge(int src, int dest) {
	        adjMatrix[src][dest] = 1;  // Set the matrix value to 1 to represent an edge
	    }

	    // Method to remove an edge from the graph (for directed graph)
	    public void removeEdge(int src, int dest) {
	        adjMatrix[src][dest] = 0;  // Set the matrix value to 0 to represent no edge
	    }

	    // Method to check if there is an edge between two vertices
	    public boolean hasEdge(int src, int dest) {
	        return adjMatrix[src][dest] == 1;  // Returns true if there is an edge, otherwise false
	    }

	    // Method to get a list of neighbors for a given vertex
	    public List<Integer> getNeighbors(int vertex) {
	        List<Integer> neighbors = new ArrayList<>();
	        for (int i = 0; i < vertices; i++) {
	            if (adjMatrix[vertex][i] == 1) { // Check for edges in the matrix
	                neighbors.add(i);  // Add to neighbors list
	            }
	        }
	        return neighbors;
	    }

	    // Method to display the adjacency matrix
	    public void printMatrix() {
	        for (int i = 0; i < vertices; i++) {
	            for (int j = 0; j < vertices; j++) {
	                System.out.print(adjMatrix[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Main method to demonstrate graph creation and functionalities
	    public static void main(String[] args) {
	    	Adjacency_Matrix  graph = new Adjacency_Matrix (5);  // Create a graph with 5 vertices

	        // Add edges to the graph
	        graph.addEdge(0, 1);
	        graph.addEdge(0, 4);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(1, 4);
	        graph.addEdge(2, 3);
	        graph.addEdge(3, 4);

	        // Print the adjacency matrix
	        System.out.println("Adjacency Matrix:");
	        graph.printMatrix();

	        // Check if there is an edge between two vertices
	        System.out.println("\nIs there an edge between vertex 1 and vertex 3? " + graph.hasEdge(1, 3));

	        // Get and print neighbors of vertex 1
	        System.out.println("\nNeighbors of vertex 1:");
	        List<Integer> neighbors = graph.getNeighbors(1);
	        for (int neighbor : neighbors) {
	            System.out.print(neighbor + " ");
	        }

	        // Remove an edge and print the updated adjacency matrix
	        System.out.println("\n\nAdjacency Matrix after removing an edge between 1 and 4:");
	        graph.removeEdge(1, 4);
	        graph.printMatrix();
	    }
	}




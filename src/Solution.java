import java.io.InputStream;
import java.util.Scanner;

/**
 * A class which runs the program, providing the solution
 */
class Solution {
    
    /**
     * The various properties of the graph that are given as input:
     * <p>
     * V = {i|i in [1, nodes]}, |E|,
     * for i := 1 ... |E|:
     *      E[i] = {(source node, dest node, edge cost)},
     * src in V, dst in V
     */
    private int nodes, edges;
    private int[][] routes;
    private int orig, target;
    
    /**
     * The solutions object constructor, which extracts the input from the provided input stream
     *
     * @param inputStream The input stream containing a description of the graph and the constraints
     */
    public Solution(InputStream inputStream) {
        // The scanner to use to read input
        Scanner input = new Scanner(inputStream).skip("\n");
        // The first line of arguments
        this.nodes = input.nextInt(); // |V|
        this.edges = input.nextInt(); // |E|
        this.routes = new int[this.nodes][3];
        // The following |routes| lines of arguments, describing each route
        for (int i = 0; i < this.nodes; i++) {
            this.routes[i] = new int[3];
            this.routes[i][0] = input.nextInt(); // src
            this.routes[i][1] = input.nextInt(); // dst
            this.routes[i][2] = input.nextInt(); // cost
        }
        // The final line of arguments, describing the goal
        this.orig = input.nextInt();
        this.target = input.nextInt();
    }
    
    /**
     * The main method which runs the entire program
     *
     * @param args The provided command line arguments, assumed to be none for this project
     */
    public static void main(String[] args) {
        System.out.print(new Solution(System.in).shortestPath());
    }
    
    /**
     * Examines the graph specified in the constructor, to extract the minimum weight path
     *
     * @return The cost of the minimum path between source and target
     */
    public int shortestPath() {
        return 0;
    }

    /**
     * Swaps two arrays in a 2-dimensional array of integers
     *
     * @param matrix The matrix of numbers to act on
     * @param index0 The index of the first item to swap
     * @param index1 The index of the second item to swap
     */
    public static void swap(int[][] matrix, int index0, int index1) {
        int[] temp = matrix[index0];
        matrix[index0] = matrix[index1];
        matrix[index1] = temp;
    }
    
}

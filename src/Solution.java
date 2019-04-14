import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * A class which runs the program, providing the solution
 */
class Solution {
    
    private int nodes, edges;
    private int[][] routes;
    private int orig, target;
    
    public Solution(InputStream inputStream, OutputStream outputStream) {
        // The scanner to use to read input
        Scanner input = new Scanner(inputStream);
        // The first line of arguments
        this.nodes = input.nextInt();
        this.edges = input.nextInt();
        this.routes = new int[this.nodes][3];
        // The following |routes| lines of arguments, describing each route
        for (int i = 0; i < this.nodes; i++) {
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
    }
    
}

import java.util.Scanner;

/**
 * A class which runs the program, providing the solution
 */
class Solution {

    private int nodes, edges;
    private int[][] routes;
    private int orig, target;

    /**
     * The main method which runs the entire program
     *
     * @param args The provided command line arguments, assumed to be none for this project
     */
    public static void main(String[] args) {
        // The scanner to use to read input
        Scanner input = new Scanner(System.in);
        // The first line of arguments
        int cities = input.nextInt();
        int routes = input.nextInt();
        // The following |routes| lines of arguments, describing each route
        for (int i = 0; i < routes; i++) {
            int src = input.nextInt();
            int dst = input.nextInt();
            int cost = input.nextInt();
        }
        // The final line of arguments, describing the goal
        int origin = input.nextInt();
        int target = input.nextInt();
    }

    public Solution(int n, int m, int[][] routes, int orig, int target) {
        this.nodes = n;
        this.edges = m;
        this.routes = routes;
        this.orig = orig;
        this.target = target;
    }

    


}
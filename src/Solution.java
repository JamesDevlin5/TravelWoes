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
    private ConsList[] routes;
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
        this.routes = new ConsList[this.nodes];
        // The following |routes| lines of arguments, describing each route
        for (int i = 0; i < this.nodes; i++) {
            int src = input.nextInt() - 1;
            int dst = input.nextInt() - 1;
            int cost = input.nextInt();
            this.routes[src] = new ConsList(dst, cost, this.routes[src]);
        }
        // The final line of arguments, describing the goal
        this.orig = input.nextInt() - 1;
        this.target = input.nextInt() - 1;
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

    private ConsList[] adjacencyList = new ConsList[this.nodes];

    public void addEdge(ConsList[] adjacencyList, int u, int v, int w) {
        this.adjacencyList[u] = new ConsList(v, w, this.adjacencyList[u]);
    }

    private class ConsList {
        int vertex, weight;
        ConsList rest;

        public ConsList(int v, int w, ConsList r) {
            this.vertex = v;
            this.weight = w;
            this.rest = r;
        }
    }

    private class MinHeap {
        int[] heap, key, pos;
        int allocatedSize, heapSize;

        public MinHeap(int size) {
            this.heap = new int[size];
            this.key = new int[size];
            this.pos = new int[size];
            this.allocatedSize = size;
            this.heapSize = size - 1;
        }

        public int size() {
            return this.heapSize;
        }

        public int getKey(int key) {
            return this.key[key];
        }

        private void swap(int a, int b) {
            this.pos[this.heap[a]] = b;
            this.pos[this.heap[b]] = a;
            int temp = this.heap[b];
            this.heap[b] = this.heap[a];
            this.heap[a] = temp;
        }

        public void initHeap(int source) {
            for (int i = 0; i < this.heapSize; i++) {
                this.heap[i] = i;
                this.pos[i] = i;
                this.key[i] = 10000000;
            }
            this.key[source] = 0;
            this.swap(0, source);
        }

        public int extractMin() {
            int res = this.heap[0];
            this.swap(0, heapSize);
            this.heapSize--;
            this.bubbleDown(0);
            return res;
        }

        public boolean decreaseKey(int u, int v, int w) {
            int newKey = this.key[u] + w;
            if (this.key[v] > newKey) {
                this.key[v] = newKey;
                this.bubbleUp(this.pos[v]);
                return true;
            }
            return false;
        }
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

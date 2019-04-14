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
    
    /**
     * Appends an edge with the specified end nodes and weight to the cons list provided
     *
     * @param adjacencyList The cons list representing the adjacency list of every node
     * @param u The start vertex of the edge
     * @param v The destination vertex of the edge
     * @param w The weight of the edge
     */
    public void addEdge(ConsList[] adjacencyList, int u, int v, int w) {
        adjacencyList[u] = new ConsList(v, w, adjacencyList[u]);
    }
    
    /**
     * A class to represent a linked list, where each node has a vertex and the associated cost of travel, along with
     * a pointer or link to the rest of the list
     */
    private class ConsList {
        /**
         * The contained information, the vertex and associated weight,
         * along with a link to the rest of the list
         */
        final int vertex, weight;
        ConsList rest;
    
        /**
         * Constructs a node in a cons list with the specified vertex and weight
         *
         * @param v The vertex this node encapsulates
         * @param w The cost of the edge to this vertex
         * @param r The rest of the cons list which this is being appended to
         */
        public ConsList(int v, int w, ConsList r) {
            this.vertex = v;
            this.weight = w;
            this.rest = r;
        }
    }
    
    /**
     * Represents a minimum heap data structure with the following properties:
     * - All levels prior to the last are completely filled, and the last level is filled to the left
     * - The key at the root is minimum among all keys present in the heap, which is recursively true for all nodes
     *
     * The elements are accessible via:
     * - Root Element (Min): arr[0]
     * - Parent node of i-th node: arr[(i-1)/2]
     * - Left child node of i-th node: arr[(2*i)+1]
     * - Right child node of i-th node: arr[(2*i)+2]
     */
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
    
        /**
         * Getter for the number of elements contained in the heap
         *
         * @return The number of items remaining in the heap
         */
        public int size() {
            return this.heapSize;
        }
    
        /**
         * Getter for the value of the key specified
         *
         * @param key The vertex integer of the key to extract
         * @return The key associated with the vertex indicated
         */
        public int getKey(int key) {
            return this.key[key];
        }
    
        /**
         * Swaps the items in the heap at index a and b
         *
         * @param a The index of the first element to swap
         * @param b The index of the second element to swap
         */
        private void swap(int a, int b) {
            this.pos[this.heap[a]] = b;
            this.pos[this.heap[b]] = a;
            int temp = this.heap[b];
            this.heap[b] = this.heap[a];
            this.heap[a] = temp;
        }
    
        /**
         * Initializes the heap such that each vertex is included once, with the maximum value excluding
         * the source which is assigned a weight of 0, so it is chosen first
         *
         * @param source The integer indication of the vertex to start with
         */
        public void initHeap(int source) {
            for (int i = 0; i < this.heapSize; i++) {
                this.heap[i] = i;
                this.pos[i] = i;
                this.key[i] = 10000000;
            }
            this.key[source] = 0;
            this.swap(0, source);
        }
    
        /**
         * Extracts the minimum key from the heap and returns it, while maintaining the required structure of the heap
         *
         * @return The current minimum key removed from the heap
         */
        public int extractMin() {
            int res = this.heap[0];
            this.swap(0, heapSize);
            this.heapSize--;
            this.bubbleDown(0);
            return res;
        }
    
        /**
         * Updates the key value associated with some vertex to be the new, provided key
         *
         * @param u The source vertex
         * @param v The adjacent vertex being examined
         * @param w The new weight to the adjacent vertex
         * @return True if the key of the adjacent vertex was decreased, false otherwise
         */
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

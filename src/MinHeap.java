/**
 * Represents a minimum heap data structure with the following properties:
 * - All levels prior to the last are completely filled, and the last level is filled to the left
 * - The key at the root is minimum among all keys present in the heap, which is recursively true for all nodes
 * <p>
 * The elements are accessible via:
 * - Root Element (Min): arr[0]
 * - Parent node of i-th node: arr[(i-1)/2]
 * - Left child node of i-th node: arr[(2*i)+1]
 * - Right child node of i-th node: arr[(2*i)+2]
 */
public class MinHeap {
    
    // heap[i] = position in heap (i) -> vertex
    private int[] heap;
    // key[i] = vertex (i) -> minimum cost path
    private int[] key;
    // pos[i] = vertex (i) -> position in heap
    private int[] pos;
    // The number of elements currently stored in the heap
    private int heapSize;
    
    /**
     * Constructs a new minimum heap with the provided number of elements specified
     *
     * @param size The number of elements to initialize data structures for
     */
    public MinHeap(int size) {
        // Ensure that the integer arrays may all store |V| values
        this.heap = new int[size + 1];
        this.key = new int[size + 1];
        this.pos = new int[size + 1];
        // There are |V| nodes in the heap, initially
        this.heapSize = size;
    }
    
    /**
     * Getter for the number of elements in the heap currently
     *
     * @return The heaps current size
     */
    public int size() {
        return this.heapSize;
    }
    
    /**
     * Getter for the value of the key specified
     *
     * @param vertex The vertex integer who's key to extract
     * @return The key associated with the vertex provided
     */
    public int getKey(int vertex) {
        return this.key[vertex];
    }
    
    /**
     * Updates the current value of the key of the destination based on the new route provided
     *
     * @param src The vertex for which a minimum route has been found
     * @param dst The vertex being examined, to determine if this route is the cheapest so far
     * @param cost The cost of traversing from the src to the dst vertices
     * @return True if the key of the destination was updated, False otherwise
     */
    public boolean updateKey(int src, int dst, int cost) {
        // Calculate the cost of the new key
        int newKey = this.key[src] + cost;
        // Check if the new route has a lower cost than the previous minimum
        if (this.key[dst] > newKey) {
            // Update the key of the vertex
            this.key[dst] = newKey;
            // Ensure that the vertex is in the correct position
            this.bubbleUp(this.pos[dst]);
            return true;
        }
        // The key was not updated since a previous route is cheaper
        return false;
    }
    
    /**
     * A utility function which bubbles a node up the heap
     *
     * @param position The position in the heap of the item to be bubbled up
     */
    private void bubbleUp(int position) {
        while (position > 1 && this.getKey(this.heap[position]) < this.getKey(this.heap[position / 2])) {
            this.swap(position, position / 2);
            position = position / 2;
        }
    }
    
    /**
     * Extracts the minimum value from the heap, indicating the cheapest next-vertex which may be routed
     *
     * @return The integer identity of the vertex with the next cheapest route
     */
    public int extractMin() {
        // The next minimum cost path will be the root node
        int minVertex = this.heap[1];
        // Swap the root node and the last leaf node
        this.swap(1, this.heapSize);
        // The node removed will now be out of scope
        this.heapSize--;
        // Ensure root node is now correct
        this.bubbleDown(1);
        return minVertex;
    }
    
    /**
     * A utility function which bubbles a node down the heap
     *
     * @param position The position in the heap of the item to be bubbled down
     */
    private void bubbleDown(int position) {
        while (position * 2 <= this.size()) {
            int minChild;
            if (position * 2 < this.size()
                        && this.key[this.heap[position * 2]] > this.key[this.heap[position * 2 + 1]])
            {
                minChild = position * 2 + 1;
            }
            else {
                minChild = position * 2;
            }
            if (this.key[this.heap[position]] > this.key[this.heap[minChild]]) {
                this.swap(position, minChild);
                position = minChild;
            }
            else {
                break;
            }
        }
    }
    
    /**
     * Initializes the heap to prepare for extracting the minimum cost path from the provided source vertex
     *
     * @param source The source vertex to analyze initially
     */
    public void initHeap(int source) {
        // Iterate all vertices
        for (int i = 1; i <= this.heapSize; i++) {
            // vertex i is located a position i for all vertices, initially
            this.heap[i] = i;
            this.pos[i] = i;
            // All vertices have the maximum possible key, initially
            this.key[i] = 10000000;
        }
        // The source should be selected initially, with a weight of 0
        this.key[source] = 0;
        // Ensure that the source is in the correct position
        this.swap(1, source);
    }
    
    /**
     * Swaps two items in the heap to facilitate bubbling items up or down
     *
     * @param index0 The index of the first item in the heap to swap
     * @param index1 The index of the second item in the heap to swap
     */
    private void swap(int index0, int index1) {
        // The position of the vertex located at index0 in heap := position of vertex at index1 in heap
        this.pos[this.heap[index0]] = index1;
        this.pos[this.heap[index1]] = index0;
        // The value of the key located at index0 in heap := value of key at index1 in heap
        int temp = this.heap[index1];
        this.heap[index1] = this.heap[index0];
        this.heap[index0] = temp;
    }
}

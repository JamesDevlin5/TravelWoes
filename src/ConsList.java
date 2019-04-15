/**
 * A class to represent a linked list, where each node has a vertex and the associated cost of travel, along with
 * a pointer or link to the rest of the list
 */
class ConsList {
    /**
     * The contained information, the vertex and associated weight,
     * along with a link to the rest of the list
     */
    private final int vertex, weight;
    private ConsList rest;
    
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
    
    /**
     * Getter for the vertex associated with this node
     *
     * @return The integer representation of the vertex contained
     */
    public int getVertex() {
        return this.vertex;
    }
    
    /**
     * Getter for the weight associated with traversal to this node
     *
     * @return The weight to travel to the vertex contained
     */
    public int getWeight() {
        return this.weight;
    }
    
    /**
     * Getter for the node containing the next link in the list
     *
     * @return The next node in the cons list
     */
    public ConsList getRest() {
        return this.rest;
    }
}

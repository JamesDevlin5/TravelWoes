import java.io.InputStream;
import java.util.Scanner;

/**
 * A supplementary class which constructs the graph specified by the input
 */
public class GraphBuilder {
    
    public int numV;
    public int numE;
    public ConsList[] edges;
    public int source;
    public int target;
    
    void setNumV(int vertices) {
        this.numV = vertices;
        this.edges = new ConsList[vertices];
    }
    
    void setNumE(int edges) {
        this.numE = edges;
    }
    
    void addEdge(int src, int dst, int cost) {
        this.edges[src] = new ConsList(dst, cost, this.edges[src]);
    }
    
    void setSource(int source) {
        this.source = source;
    }
    
    void setTarget(int target) {
        this.target = target;
    }
    
    public void parseInput(InputStream inputStream) {
        // The scanner to use to read input
        Scanner input = new Scanner(inputStream);
        // The first line of arguments
        this.setNumV(input.nextInt()); // |V|
        this.setNumE(input.nextInt()); // |E|
        // The following |routes| lines of arguments, describing each route
        for (int i = 0; i < this.numE; i++) {
            int src = input.skip("\n").nextInt() - 1;
            int dst = input.nextInt() - 1;
            int cost = input.nextInt();
            this.addEdge(src, dst, cost);
        }
        // The final line of arguments, describing the goal
        this.setSource(input.skip("\n").nextInt() - 1);
        this.setTarget(input.nextInt() - 1);
    }
    
}

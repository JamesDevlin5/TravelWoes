import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for GraphBuilder
 */
class GraphBuilderTest {
    
    GraphBuilder tester;
    
    @BeforeEach
    void setUp() {
        this.tester = new GraphBuilder();
    }
    
    String input1 = new StringBuilder()
            .append("1 1\n")
            .append("1 1 1\n")
            .append("1 1\n")
            .toString();
    
    @Test
    void parseInputTest1() {
        this.tester.parseInput(new ByteArrayInputStream( this.input1.getBytes()));
        assertEquals(1, this.tester.numV);
        assertEquals(1, this.tester.numE);
        assertEquals(0, this.tester.edges[0].getVertex());
        assertEquals(1, this.tester.edges[0].getWeight());
        assertEquals(0, this.tester.source);
        assertEquals(0, this.tester.target);
    }
    
    String input2 = new StringBuilder()
            .append("6 1\n")
            .append("2 3 1\n")
            .append("1 2\n")
            .toString();
    
    @Test
    void parseInputTest2() {
        this.tester.parseInput(new ByteArrayInputStream(this.input2.getBytes()));
        assertEquals(6, this.tester.numV);
        assertEquals(1, this.tester.numE);
        assertEquals(2, this.tester.edges[1].getVertex());
        assertEquals(1, this.tester.edges[1].getWeight());
        assertEquals(0, this.tester.source);
        assertEquals(1, this.tester.target);
    }
    
    String input3 = new StringBuilder()
            .append("4 4\n")
            .append("1 2 1\n")
            .append("4 1 2\n")
            .append("2 3 2\n")
            .append("1 3 5\n")
            .append("1 3\n")
            .toString();
    
    @Test
    void parseInputTest3() {
        this.tester.parseInput(new ByteArrayInputStream(this.input3.getBytes()));
        assertEquals(4, this.tester.numV);
        assertEquals(4, this.tester.numE);
        assertEquals(1, this.tester.edges[0].getRest().getVertex());
        assertEquals(1, this.tester.edges[0].getRest().getWeight());
        assertEquals(0, this.tester.edges[3].getVertex());
        assertEquals(2, this.tester.edges[3].getWeight());
        assertEquals(2, this.tester.edges[1].getVertex());
        assertEquals(2, this.tester.edges[1].getWeight());
        assertEquals(2, this.tester.edges[0].getVertex());
        assertEquals(5, this.tester.edges[0].getWeight());
        assertEquals(0, this.tester.source);
        assertEquals(2, this.tester.target);
    }
    
    String input4 = new StringBuilder()
            .append("4 4\n")
            .append("4 1 1\n")
            .append("1 3 2\n")
            .append("4 3 4\n")
            .append("2 4 1\n")
            .append("4 2\n")
            .toString();
    
    @Test
    void parseInputTest4() {
        this.tester.parseInput(new ByteArrayInputStream(this.input4.getBytes()));
        assertEquals(4, this.tester.numV);
        assertEquals(4, this.tester.numE);
        assertEquals(0, this.tester.edges[3].getRest().getVertex());
        assertEquals(1, this.tester.edges[3].getRest().getWeight());
        assertEquals(2, this.tester.edges[0].getVertex());
        assertEquals(2, this.tester.edges[0].getWeight());
        assertEquals(2, this.tester.edges[3].getVertex());
        assertEquals(4, this.tester.edges[3].getWeight());
        assertEquals(3, this.tester.edges[1].getVertex());
        assertEquals(1, this.tester.edges[1].getWeight());
        assertEquals(3, this.tester.source);
        assertEquals(1, this.tester.target);
    }
    
    String input5 = new StringBuilder()
            .append("8 8\n")
            .append("2 1 1\n")
            .append("3 2 2\n")
            .append("4 3 3\n")
            .append("5 4 4\n")
            .append("6 5 5\n")
            .append("7 6 6\n")
            .append("8 7 7\n")
            .append("1 8 8\n")
            .append("1 4\n")
            .toString();
    
    @Test
    void parseInputTest5() {
        this.tester.parseInput(new ByteArrayInputStream(this.input5.getBytes()));
        assertEquals(8, this.tester.numV);
        assertEquals(8, this.tester.numE);
        assertEquals(0, this.tester.edges[1].getVertex());
        assertEquals(1, this.tester.edges[1].getWeight());
        assertEquals(1, this.tester.edges[2].getVertex());
        assertEquals(2, this.tester.edges[2].getWeight());
        assertEquals(2, this.tester.edges[3].getVertex());
        assertEquals(3, this.tester.edges[3].getWeight());
        assertEquals(3, this.tester.edges[4].getVertex());
        assertEquals(4, this.tester.edges[4].getWeight());
        assertEquals(4, this.tester.edges[5].getVertex());
        assertEquals(5, this.tester.edges[5].getWeight());
        assertEquals(5, this.tester.edges[6].getVertex());
        assertEquals(6, this.tester.edges[6].getWeight());
        assertEquals(6, this.tester.edges[7].getVertex());
        assertEquals(7, this.tester.edges[7].getWeight());
        assertEquals(7, this.tester.edges[0].getVertex());
        assertEquals(8, this.tester.edges[0].getWeight());
        assertEquals(0, this.tester.source);
        assertEquals(3, this.tester.target);
    }
    
    String input6 = new StringBuilder()
            .append("5 9\n")
            .append("1 2 4\n")
            .append("1 3 2\n")
            .append("2 3 2\n")
            .append("3 2 1\n")
            .append("2 4 2\n")
            .append("3 5 4\n")
            .append("5 4 1\n")
            .append("2 5 3\n")
            .append("3 4 4\n")
            .append("1 5\n")
            .toString();
    
    @Test
    void parseInputTest6() {
        this.tester.parseInput(new ByteArrayInputStream(this.input6.getBytes()));
        assertEquals(5, this.tester.numV);
        assertEquals(9, this.tester.numE);
        assertEquals(1, this.tester.edges[0].getRest().getVertex());
        assertEquals(4, this.tester.edges[0].getRest().getWeight());
        assertEquals(2, this.tester.edges[0].getVertex());
        assertEquals(2, this.tester.edges[0].getWeight());
        assertEquals(2, this.tester.edges[1].getRest().getRest().getVertex());
        assertEquals(2, this.tester.edges[1].getRest().getRest().getWeight());
        assertEquals(1, this.tester.edges[2].getRest().getRest().getVertex());
        assertEquals(1, this.tester.edges[2].getRest().getRest().getWeight());
        assertEquals(3, this.tester.edges[1].getRest().getVertex());
        assertEquals(2, this.tester.edges[1].getRest().getWeight());
        assertEquals(4, this.tester.edges[2].getRest().getVertex());
        assertEquals(4, this.tester.edges[2].getRest().getWeight());
        assertEquals(3, this.tester.edges[4].getVertex());
        assertEquals(1, this.tester.edges[4].getWeight());
        assertEquals(4, this.tester.edges[1].getVertex());
        assertEquals(3, this.tester.edges[1].getWeight());
        assertEquals(3, this.tester.edges[2].getVertex());
        assertEquals(4, this.tester.edges[2].getWeight());
        assertEquals(0, this.tester.source);
        assertEquals(4, this.tester.target);
        
    }
}

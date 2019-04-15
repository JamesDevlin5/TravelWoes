import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for ConsList
 */
class ConsListTest {
    
    @Test
    void simpleTest() {
        ConsList test = null;
        for (int i = 0; i < 20; i++) {
            test = new ConsList(i, i * 4, test);
        }
        for (int i = 19; i >= 0; i--) {
            assertEquals(i, test.getVertex());
            assertEquals(i * 4, test.getWeight());
            test = test.getRest();
        }
        assertNull(test);
    }
    
    @Test
    void randomTest() {
        LinkedList<testNode> copyList = new LinkedList<>();
        ConsList consList = null;
        Random random = new Random();
        for (int i = 0; i < random.nextInt(); i++) {
            int node = random.nextInt();
            int weight = random.nextInt();
            copyList.addFirst(new testNode(node, weight));
            consList = new ConsList(node, weight, consList);
        }
        while (consList != null) {
            testNode compare = copyList.removeFirst();
            assertEquals(compare.vertex, consList.getVertex());
            assertEquals(compare.weight, consList.getWeight());
            consList = consList.getRest();
        }
    }
    
    /**
     * A very simple test class which holds a vertex and a weight, emulating a node in a list
     */
    class testNode {
        int vertex, weight;
        
        testNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

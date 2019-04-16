import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A testing class for the solution to the travel woes problem
 */
class SolutionTest {
    
    /**
     * Boolean values indicating whether to test certain groupings
     */
    private final boolean testProvided = true;
    
    /**
     * The test values provided in the question
     */
    private Integer[][] provided1;
    private Integer[][] provided2;
    private Integer[][] provided3;
    private Integer[][] provided4;
    
    @BeforeEach
    void setUp() {
        this.provided1 = new Integer[][]{
                {4, 4},
                {1, 2, 1},
                {4, 1, 2},
                {2, 3, 2},
                {1, 3, 5},
                {1, 3}
        };
        this.provided2 = new Integer[][]{
                {4, 4},
                {4, 1, 1},
                {1, 3, 2},
                {4, 3, 4},
                {2, 4, 1},
                {4, 2}
        };
        this.provided3 = new Integer[][]{
                {8, 8},
                {2, 1, 1},
                {3, 2, 2},
                {4, 3, 3},
                {5, 4, 4},
                {6, 5, 5},
                {7, 6, 6},
                {8, 7, 7},
                {1, 8, 8},
                {1, 4}
        };
        this.provided4 = new Integer[][]{
                {5, 9},
                {1, 2, 4},
                {1, 3, 2},
                {2, 3, 2},
                {3, 2, 1},
                {2, 4, 2},
                {3, 5, 4},
                {5, 4, 1},
                {2, 5, 3},
                {3, 4, 4},
                {1, 5}
        };
    }
    
    @Test
    void solTest() {
        List<Integer[][]> tests = new LinkedList<>();
        List<Integer> results = new LinkedList<>();
        if (this.testProvided) {
            tests.add(this.provided1);
            results.add(3);
            tests.add(this.provided2);
            results.add(-1);
            tests.add(this.provided3);
            results.add(30);
            tests.add(this.provided4);
            results.add(6);
        }
        
        Iterator<Integer> resultIter = results.iterator();
        for (Integer[][] test : tests) {
            StringBuilder testString = new StringBuilder();
            testString
                    .append(test[0][0]).append(" ")             // |V|
                    .append(test[0][1]).append("\n");           // |E|
            for (int r = 1; r < test[0][1] + 1; r++) {              // for i := 1 ... |E|
                testString.append(test[r][0]).append(" ")       // src
                        .append(test[r][1]).append(" ")         // dst
                        .append(test[r][2]).append("\n");       // cost
            }
            testString
                    .append(test[test.length - 1][0]).append(" ")
                    .append(test[test.length - 1][1]);
            Solution solution = new Solution();
            solution.parseInput(new ByteArrayInputStream(testString.toString().getBytes()));
            assertTrue(resultIter.hasNext());
            assertEquals(resultIter.next(), solution.shortestPath());
        }
    }
}

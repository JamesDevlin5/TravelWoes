import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A testing class for the solution to the travel woes problem
 */
class SolutionTest {
    
    /**
     * The test values provided in the question
     */
    private int[][] provided1;
    private int[][] provided2;
    private int[][] provided3;
    private int[][] provided4;
    
    @BeforeEach
    void setUp() {
        this.provided1 = new int[][]{
                {4, 4},
                {1, 2, 1},
                {4, 1, 2},
                {2, 3, 2},
                {1, 3, 5},
                {1, 3}
        };
        this.provided2 = new int[][]{
                {4, 4},
                {4, 1, 1},
                {1, 3, 2},
                {4, 3, 4},
                {2, 4, 1},
                {4, 2}
        };
        this.provided3 = new int[][]{
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
        this.provided4 = new int[][]{
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
    
    }
}

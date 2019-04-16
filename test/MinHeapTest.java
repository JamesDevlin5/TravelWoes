import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for MinHeap
 */
class MinHeapTest {
    
    MinHeap heap1;
    MinHeap heap2;
    MinHeap heap3;
    MinHeap heap4;
    
    @BeforeEach
    void setUp() {
        this.heap1 = new MinHeap(1);
        this.heap2 = new MinHeap(2);
        this.heap3 = new MinHeap(3);
        this.heap4 = new MinHeap(7);
        
    }
    
    @Test
    void testHeap1() {
        this.heap1.initHeap(1);
        assertEquals(1, this.heap1.size());
        assertEquals(1, this.heap1.extractMin());
        assertEquals(0, this.heap1.getKey(1));
        assertEquals(0, this.heap1.size());
    }
    
    @Test
    void testHeap2() {
        this.heap2.initHeap(2);
        assertEquals(2, this.heap2.size());
        assertEquals(2, this.heap2.extractMin());
        assertEquals(0, this.heap2.getKey(2));
        assertEquals(1, this.heap2.size());
        assertTrue(this.heap2.updateKey(2, 1, 33));
        assertEquals(1, this.heap2.extractMin());
        assertEquals(33, this.heap2.getKey(1));
        assertEquals(0, this.heap2.size());
    }
    
    @Test
    void testHeap3() {
        this.heap3.initHeap(3);
        assertEquals(3, this.heap3.size());
        assertEquals(3, this.heap3.extractMin());
        assertEquals(0, this.heap3.getKey(3));
        assertEquals(2, this.heap3.size());
        assertTrue(this.heap3.updateKey(3, 2, 20));
        assertTrue(this.heap3.updateKey(3, 1, 30));
        assertEquals(2, this.heap3.extractMin());
        assertEquals(20, this.heap3.getKey(2));
        assertEquals(1, this.heap3.size());
        assertEquals(1, this.heap3.extractMin());
        assertEquals(30, this.heap3.getKey(1));
        assertEquals(0, this.heap3.size());
    }
    
    @Test
    void testHeap4() {
        this.heap4.initHeap(5);
        assertTrue(this.heap4.updateKey(5, 1, 10));
        assertTrue(this.heap4.updateKey(5, 2, 20));
        assertTrue(this.heap4.updateKey(5, 3, 30));
        assertTrue(this.heap4.updateKey(5, 4, 40));
        assertFalse(this.heap4.updateKey(5, 5, 50));
        assertTrue(this.heap4.updateKey(5, 6, 60));
        assertTrue(this.heap4.updateKey(5, 7, 70));
        assertEquals(5, this.heap4.extractMin());
        assertEquals(1, this.heap4.extractMin());
        assertEquals(2, this.heap4.extractMin());
        assertEquals(3, this.heap4.extractMin());
        assertEquals(4, this.heap4.extractMin());
        assertEquals(6, this.heap4.extractMin());
        assertEquals(7, this.heap4.extractMin());
        assertEquals(10, this.heap4.getKey(1));
        assertEquals(20, this.heap4.getKey(2));
        assertEquals(30, this.heap4.getKey(3));
        assertEquals(40, this.heap4.getKey(4));
        assertEquals(0, this.heap4.getKey(5));
        assertEquals(60, this.heap4.getKey(6));
        assertEquals(70, this.heap4.getKey(7));
        assertEquals(0, this.heap4.size());
    }
}

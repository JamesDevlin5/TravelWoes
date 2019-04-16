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
        this.heap1.initHeap(0);
        assertEquals(1, this.heap1.size());
        assertEquals(0, this.heap1.extractMin());
        assertEquals(0, this.heap1.getKey(0));
        assertEquals(0, this.heap1.size());
    }
    
    @Test
    void testHeap2() {
        this.heap2.initHeap(1);
        assertEquals(2, this.heap2.size());
        assertEquals(1, this.heap2.extractMin());
        assertEquals(0, this.heap2.getKey(1));
        assertEquals(1, this.heap2.size());
        this.heap2.updateKey(1, 0, 33);
        assertEquals(0, this.heap2.extractMin());
        assertEquals(33, this.heap2.getKey(0));
        assertEquals(0, this.heap2.size());
    }
    
    @Test
    void testHeap3() {
        this.heap3.initHeap(2);
        assertEquals(3, this.heap3.size());
        assertEquals(2, this.heap3.extractMin());
        assertEquals(0, this.heap3.getKey(2));
        assertEquals(2, this.heap3.size());
        this.heap3.updateKey(2, 1, 20);
        this.heap3.updateKey(2, 0, 30);
        assertEquals(1, this.heap3.extractMin());
        assertEquals(20, this.heap3.getKey(1));
        assertEquals(1, this.heap3.size());
        assertEquals(0, this.heap3.extractMin());
        assertEquals(30, this.heap3.getKey(0));
        assertEquals(0, this.heap3.size());
    }
    
    @Test
    void testHeap4() {
        this.heap4.initHeap(5);
        this.heap4.updateKey(5, 0, 10);
        this.heap4.updateKey(5, 1, 20);
        this.heap4.updateKey(5, 2, 30);
        this.heap4.updateKey(5, 3, 40);
        this.heap4.updateKey(5, 4, 50);
        this.heap4.updateKey(5, 5, 60);
        this.heap4.updateKey(5, 6, 70);
        assertEquals(5, this.heap4.extractMin());
        assertEquals(0, this.heap4.extractMin());
        assertEquals(1, this.heap4.extractMin());
        assertEquals(2, this.heap4.extractMin());
        assertEquals(3, this.heap4.extractMin());
        assertEquals(4, this.heap4.extractMin());
        assertEquals(6, this.heap4.extractMin());
        assertEquals(10, this.heap4.getKey(0));
        assertEquals(20, this.heap4.getKey(1));
        assertEquals(30, this.heap4.getKey(2));
        assertEquals(40, this.heap4.getKey(3));
        assertEquals(50, this.heap4.getKey(4));
        assertEquals(0, this.heap4.getKey(5));
        assertEquals(70, this.heap4.getKey(6));
        assertEquals(0, this.heap4.size());
    }
}

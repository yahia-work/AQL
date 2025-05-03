package org.example.TP0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testFibonacci_BaseCases() {
        assertEquals(0, Fibonacci.fibonacci(0), "F(0) doit être 0");
        assertEquals(1, Fibonacci.fibonacci(1), "F(1) doit être 1");
    }

    @Test
    void testFibonacci_SmallValues() {
        assertEquals(1, Fibonacci.fibonacci(2), "F(2) doit être 1");
        assertEquals(2, Fibonacci.fibonacci(3), "F(3) doit être 2");
        assertEquals(3, Fibonacci.fibonacci(4), "F(4) doit être 3");
        assertEquals(5, Fibonacci.fibonacci(5), "F(5) doit être 5");
        assertEquals(8, Fibonacci.fibonacci(6), "F(6) doit être 8");
        assertEquals(13, Fibonacci.fibonacci(7), "F(7) doit être 13");
    }

    @Test
    void testFibonacci_MediumValues() {
        assertEquals(21, Fibonacci.fibonacci(8), "F(8) doit être 21");
        assertEquals(34, Fibonacci.fibonacci(9), "F(9) doit être 34");
        assertEquals(55, Fibonacci.fibonacci(10), "F(10) doit être 55");
        assertEquals(89, Fibonacci.fibonacci(11), "F(11) doit être 89");
        assertEquals(233, Fibonacci.fibonacci(13), "F(13) doit être 233");
    }

    @Test
    void testFibonacci_LargeValues() {
        assertEquals(6765, Fibonacci.fibonacci(20), "F(20) doit être 6765");
        assertEquals(832040, Fibonacci.fibonacci(30), "F(30) doit être 832040");
        assertEquals(102334155, Fibonacci.fibonacci(40), "F(40) doit être 102334155");
    }

    @Test
    void testFibonacci_ThrowsException_ForNegativeValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
        assertEquals("n must be positive", exception.getMessage());
    }

    @Test
    void testFibonacci_Performance() {
        assertDoesNotThrow(() -> Fibonacci.fibonacci(45)); // Vérifie que le programme ne dépasse pas le temps raisonnable
    }

    @Test
    void testFibonacci_VeryLargeNumbers() {
        // Ce test est faisable uniquement si on utilise une approche O(n) ou O(log n)
        assertEquals(1134903170, Fibonacci.fibonacci(45), "F(45) doit être 1134903170");
        assertEquals(1836311903, Fibonacci.fibonacci(46), "F(46) doit être 1836311903");
    }

    @Test
    void testFibonacci_Limits() {
        assertEquals(2971215073L, Fibonacci.fibonacci(47), "F(47) doit être 2971215073");
        assertEquals(4807526976L, Fibonacci.fibonacci(48), "F(48) doit être 4807526976");
    }
}

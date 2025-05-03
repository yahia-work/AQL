package org.example.TP0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testFactorial_BaseCases() {
        assertEquals(1, Factorial.factorial(0), "0! doit être 1");
        assertEquals(1, Factorial.factorial(1), "1! doit être 1");
    }

    @Test
    void testFactorial_SmallNumbers() {
        assertEquals(2, Factorial.factorial(2), "2! doit être 2");
        assertEquals(6, Factorial.factorial(3), "3! doit être 6");
        assertEquals(24, Factorial.factorial(4), "4! doit être 24");
        assertEquals(120, Factorial.factorial(5), "5! doit être 120");
    }

    @Test
    void testFactorial_MediumNumbers() {
        assertEquals(720, Factorial.factorial(6), "6! doit être 720");
        assertEquals(5040, Factorial.factorial(7), "7! doit être 5040");
        assertEquals(40320, Factorial.factorial(8), "8! doit être 40320");
        assertEquals(362880, Factorial.factorial(9), "9! doit être 362880");
        assertEquals(3628800, Factorial.factorial(10), "10! doit être 3628800");
    }

    @Test
    void testFactorial_LargeNumber() {
        assertEquals(479001600, Factorial.factorial(12), "12! doit être 479001600");
    }

    @Test
    void testFactorial_NegativeNumber_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
        assertEquals("n must be positive", exception.getMessage());
    }

    @Test
    void testFactorial_IntegerOverflow() {
        Exception exception = assertThrows(ArithmeticException.class, () -> Factorial.factorial(20));
        assertTrue(exception.getMessage().contains("integer overflow"), "Factorial(20) dépasse la capacité d'un int");
    }
}

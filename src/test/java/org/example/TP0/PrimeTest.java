package org.example.TP0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void testIsPrime_SmallNumbers() {
        assertFalse(Prime.isPrime(0), "0 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(1), "1 n'est pas un nombre premier");
        assertTrue(Prime.isPrime(2), "2 est un nombre premier");
        assertTrue(Prime.isPrime(3), "3 est un nombre premier");
        assertFalse(Prime.isPrime(4), "4 n'est pas un nombre premier");
    }

    @Test
    void testIsPrime_PrimeNumbers() {
        assertTrue(Prime.isPrime(5), "5 est premier");
        assertTrue(Prime.isPrime(7), "7 est premier");
        assertTrue(Prime.isPrime(11), "11 est premier");
        assertTrue(Prime.isPrime(13), "13 est premier");
        assertTrue(Prime.isPrime(17), "17 est premier");
    }

    @Test
    void testIsPrime_NonPrimeNumbers() {
        assertFalse(Prime.isPrime(9), "9 n'est pas premier");
        assertFalse(Prime.isPrime(15), "15 n'est pas premier");
        assertFalse(Prime.isPrime(21), "21 n'est pas premier");
        assertFalse(Prime.isPrime(25), "25 n'est pas premier");
    }

    @Test
    void testIsPrime_LargePrimeNumbers() {
        assertTrue(Prime.isPrime(97), "97 est un nombre premier");
        assertTrue(Prime.isPrime(101), "101 est un nombre premier");
        assertTrue(Prime.isPrime(199), "199 est un nombre premier");
        assertTrue(Prime.isPrime(997), "997 est un nombre premier");
    }

    @Test
    void testIsPrime_LargeNonPrimeNumbers() {
        assertFalse(Prime.isPrime(100), "100 n'est pas premier");
        assertFalse(Prime.isPrime(200), "200 n'est pas premier");
        assertFalse(Prime.isPrime(1000), "1000 n'est pas premier");
    }

    @Test
    void testIsPrime_Performance() {
        assertDoesNotThrow(() -> Prime.isPrime(2147483647), "Doit traiter les grands nombres efficacement");
    }
}

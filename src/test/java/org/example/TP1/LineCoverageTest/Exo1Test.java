package org.example.TP1.LineCoverageTest;

import org.example.TP1.Exo1.Palindrom_Correction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    @Test
    public void testPalindromeEvenLength() {
        assertTrue(Palindrom_Correction.isPalindrome("abba"));
    }

    @Test
    public void testPalindromeOddLength() {
        assertTrue(Palindrom_Correction.isPalindrome("radar"));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse(Palindrom_Correction.isPalindrome("papa"));
    }

    @Test
    public void testWithSpaces() {
        assertTrue(Palindrom_Correction.isPalindrome("a bcd a bccb a dcb a"));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrom_Correction.isPalindrome(null));
    }

}

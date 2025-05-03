package org.example.TP1.BranchCoverageTest;

import org.example.TP1.Exo1.Palindrom_Correction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Exo1Test {

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrom_Correction.isPalindrome(null));
    }

    @Test
    public void testDifferentCharacters() {
        assertFalse(Palindrom_Correction.isPalindrome("abc"));
    }

    @Test
    public void testSameCharacters() {
        assertTrue(Palindrom_Correction.isPalindrome("aba"));
    }
}

package org.example.TP0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGetFullName() {
        Person person = new Person("Amine", "SE", 24);
        assertEquals("Amine SE", person.getFullName());
    }

    @Test
    void testGetFullName_WithEmptyNames() {
        Person person = new Person("", "", 24);
        assertEquals(" ", person.getFullName());
    }

    @Test
    void testGetFullName_WithSingleName() {
        Person person = new Person("Amine", "", 24);
        assertEquals("Amine ", person.getFullName());

        Person person2 = new Person("", "SE", 24);
        assertEquals(" SE", person2.getFullName());
    }

    @Test
    void testIsAdult_WhenAgeIs18OrMore() {
        Person adult = new Person("yahia", "hn", 18);
        assertTrue(adult.isAdult());

        Person olderAdult = new Person("adem", "reg", 47);
        assertTrue(olderAdult.isAdult());
    }

    @Test
    void testIsAdult_WhenAgeIsLessThan18() {
        Person child = new Person("yahia", "hen", 13);
        assertFalse(child.isAdult());
    }

    @Test
    void testIsAdult_WhenAgeIsExactly18() {
        Person person = new Person("yahia", "hen", 18);
        assertTrue(person.isAdult());
    }

    @Test
    void testIsAdult_WithNegativeAge() {
        Person person = new Person("reg", "youyou", -23);
        assertFalse(person.isAdult());
    }

    @Test
    void testIsAdult_WithZeroAge() {
        Person person = new Person("amire", "nl", 0);
        assertFalse(person.isAdult());
    }
}

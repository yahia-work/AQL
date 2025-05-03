package org.example.TP0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;

    @BeforeEach
    void instance() {
        stack = new Stack();
    }

    @Test
    void testPush_AndSize() {
        assertEquals(0, stack.size());

        stack.push(10);
        assertEquals(1, stack.size());

        stack.push(20);
        assertEquals(2, stack.size());
    }

    @Test
    void testPop_ReturnsLastPushedElement() {
        stack.push(5);
        stack.push(10);

        assertEquals(10, stack.pop());
        assertEquals(1, stack.size());

        assertEquals(5, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void testPop_ThrowsException_WhenStackIsEmpty() {
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testPeek_ReturnsLastElementWithoutRemoving() {
        stack.push(100);
        stack.push(200);

        assertEquals(200, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testPeek_ThrowsException_WhenStackIsEmpty() {
        Exception exception = assertThrows(IllegalStateException.class, stack::peek);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testIsEmpty_WhenNewStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmpty_AfterPushAndPop() {
        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testStackExpansion() {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.pop());
    }

    @Test
    void testMultiplePushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPushNegativeValues() {
        stack.push(-5);
        stack.push(-10);
        assertEquals(-10, stack.pop());
        assertEquals(-5, stack.pop());
    }

    @Test
    void testPushZero() {
        stack.push(0);
        assertEquals(0, stack.pop());
    }

    @Test
    void testSize_AfterPushingAndPopping() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void testSize_AfterClearingStack() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void testPushAndPeek_MultipleTimes() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        stack.push(30);
        assertEquals(30, stack.peek());
    }
    @Test
    void testLargeNumberOfPushesAndPops() {
        for (int i = 0; i < 10000; i++) {
            stack.push(i);
        }
        for (int i = 9999; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.isEmpty());
    }

}

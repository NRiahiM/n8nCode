package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumberUtilsTest {

    @Test
    public void testMaxNormal() {
        double[] v = {1, 5, 3, 2};
        assertEquals(5.0, NumberUtils.max(v), 0.0);
    }

    @Test
    public void testMaxNegative() {
        double[] v = {-10, -3, -20};
        assertEquals(-3.0, NumberUtils.max(v), 0.0);
    }

    @Test
    public void testMaxDecimals() {
        double[] v = {1.5, 2.75, 2.7};
        assertEquals(2.75, NumberUtils.max(v), 1e-9);
    }

    @Test
    public void testSingleElement() {
        double[] v = {42};
        assertEquals(42.0, NumberUtils.max(v), 0.0);
    }

    @Test
    public void testAllEqual() {
        double[] v = {3,3,3};
        assertEquals(3.0, NumberUtils.max(v), 0.0);
    }

    @Test
    public void testEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.max(new double[0]));
    }

    @Test
    public void testParseDoublesValid() {
        String[] tokens = {"1", "2.5", "-3"};
        double[] arr = NumberUtils.parseDoubles(tokens);
        assertArrayEquals(new double[]{1.0, 2.5, -3.0}, arr, 0.0);
    }

    @Test
    public void testParseDoublesInvalid() {
        String[] tokens = {"1", "a", "3"};
        assertThrows(NumberFormatException.class, () -> NumberUtils.parseDoubles(tokens));
    }
}

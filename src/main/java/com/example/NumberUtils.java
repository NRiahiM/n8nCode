package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class NumberUtils {

    private NumberUtils() { }

    /**
     * Returns the maximum value in the array.
     * @throws IllegalArgumentException if values is null or empty
     */
    public static double max(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Cannot determine max of empty array");
        }
        double m = values[0];
        for (int i = 1; i < values.length; i++) {
            if (Double.isNaN(values[i])) {
                // propagate NaN behavior
                return Double.NaN;
            }
            if (values[i] > m) {
                m = values[i];
            }
        }
        return m;
    }

    /**
     * Parses an array of string tokens into doubles. Throws NumberFormatException on invalid token.
     */
    public static double[] parseDoubles(String[] tokens) {
        if (tokens == null) return new double[0];
        double[] arr = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Double.parseDouble(tokens[i]);
        }
        return arr;
    }

    /**
     * Reads all whitespace-separated tokens from stdin and parses them as doubles.
     * Throws NumberFormatException on invalid token.
     */
    public static double[] readDoublesFromStdin() {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        while (sc.hasNext()) {
            String tok = sc.next();
            list.add(Double.parseDouble(tok));
        }
        sc.close();
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}

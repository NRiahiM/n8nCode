package com.example;

import java.util.Arrays;

public class MaxFinder {

    private static final String USAGE = "استفاده: java -jar maxfinder.jar [numbers...]\n" +
            "یا: echo \"1 2 3\" | java -jar maxfinder.jar\n" +
            "اعداد می‌توانند اعشاری باشند (مثال: 3.14)";

    public static void main(String[] args) {
        try {
            double[] numbers;
            if (args.length == 0) {
                // read from stdin
                numbers = NumberUtils.readDoublesFromStdin();
            } else {
                if (args.length == 1 && ("-h".equals(args[0]) || "--help".equals(args[0]))) {
                    System.out.println(USAGE);
                    return;
                }
                numbers = NumberUtils.parseDoubles(args);
            }

            if (numbers.length == 0) {
                System.err.println("خطا: هیچ عددی دریافت نشد.");
                System.exit(1);
            }

            double max = NumberUtils.max(numbers);
            // Print as integer if it's a whole number to improve readability
            if (max == Math.rint(max)) {
                System.out.println(String.format("%.0f", max));
            } else {
                System.out.println(max);
            }
        } catch (NumberFormatException ex) {
            System.err.println("خطا: ورودی شامل عدد نامعتبر است: " + ex.getMessage());
            System.exit(2);
        } catch (IllegalArgumentException ex) {
            System.err.println("خطا: " + ex.getMessage());
            System.exit(1);
        }
    }
}

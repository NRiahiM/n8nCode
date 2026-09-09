package com.example;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10; // تعداد اعداد فیبوناچی که باید تولید شود
        int a = 0, b = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(" ");
            sb.append(a);
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println(sb.toString());
    }
}

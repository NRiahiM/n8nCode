package com.example;

import java.util.Scanner;

/**
 * برنامهٔ ساده برای گرفتن دو عدد و نمایش عدد بزرگ‌تر یا پیام برابر بودن.
 *
 * تابع max برای منطق مقایسه جدا شده تا قابل تست باشد.
 */
public class MaxOfTwo {

    /**
     * برمی‌گرداند بزرگ‌ترین مقدار میان a و b.
     * اگر برابر باشند مقدار a بازگردانده می‌شود (که همان مقدار مشترک است).
     *
     * @param a عدد اول
     * @param b عدد دوم
     * @return بزرگ‌ترین عدد (یا مقدار مشترک در حالت برابر)
     */
    public static double max(double a, double b) {
        // استفاده از >= تا در صورت برابر بودن مقدار a بازگردانده شود.
        return (a >= b) ? a : b;
    }

    private static double parseDouble(String s) throws NumberFormatException {
        if (s == null) throw new NumberFormatException("null");
        s = s.trim();
        // پذیرش ورودی‌هایی که از کاما به‌عنوان جداکننده اعشاری استفاده می‌کنند
        // (مثلاً در برخی لوکال‌ها). تبدیل به نقطه می‌کنیم و سپس parse می‌نماییم.
        s = s.replace(',', '.');
        return Double.parseDouble(s);
    }

    private static String formatDouble(double d) {
        // اگر عدد بدون بخش اعشاری باشد، آن را به‌صورت عدد صحیح چاپ می‌کنیم
        if (Double.isFinite(d) && d == Math.rint(d)) {
            long asLong = (long) d;
            return String.valueOf(asLong);
        }
        return String.valueOf(d);
    }

    public static void main(String[] args) {
        double a, b;
        try {
            if (args.length >= 2) {
                a = parseDouble(args[0]);
                b = parseDouble(args[1]);
            } else {
                try (Scanner sc = new Scanner(System.in)) {
                    System.out.print("عدد اول را وارد کنید: ");
                    String s1 = sc.nextLine();
                    System.out.print("عدد دوم را وارد کنید: ");
                    String s2 = sc.nextLine();
                    a = parseDouble(s1);
                    b = parseDouble(s2);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("خطا: ورودی نامعتبر. لطفاً یک عدد صحیح یا اعشاری وارد کنید.");
            System.exit(1);
        }

        if (Double.compare(a, b) == 0) {
            System.out.println("اعداد برابرند: " + formatDouble(a));
        } else {
            double result = max(a, b);
            System.out.println(formatDouble(result));
        }
        System.exit(0);
    }
}

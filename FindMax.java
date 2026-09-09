import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("لطفاً یک لیست از اعداد را وارد کنید (با فاصله جدا کنید) و سپس Enter بزنید:");
        String line = scanner.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("هیچ عددی وارد نشده است.");
            return;
        }

        String[] parts = line.split("\\s+");
        double max = Double.NEGATIVE_INFINITY;
        boolean any = false;

        for (String p : parts) {
            try {
                double v = Double.parseDouble(p);
                if (!any || v > max) {
                    max = v;
                }
                any = true;
            } catch (NumberFormatException e) {
                System.out.println("عبارت نامعتبر نادیده گرفته شد: " + p);
            }
        }

        if (!any) {
            System.out.println("هیچ عدد معتبری وارد نشد.");
        } else {
            // اگر عدد صحیح است، به صورت صحیح نمایش می‌دهیم
            if (max == (long) max) {
                System.out.println("بزرگ‌ترین عدد: " + (long) max);
            } else {
                System.out.println("بزرگ‌ترین عدد: " + max);
            }
        }

        scanner.close();
    }
}

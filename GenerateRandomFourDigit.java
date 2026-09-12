public class GenerateRandomFourDigit {
    public static void main(String[] args) {
        final int COUNT = 50;
        int[] numbers = new int[COUNT];

        java.util.concurrent.ThreadLocalRandom random = java.util.concurrent.ThreadLocalRandom.current();

        // تولید ۵۰ عدد چهار رقمی تصادفی در بازه [1000, 9999]
        for (int i = 0; i < COUNT; i++) {
            numbers[i] = random.nextInt(1000, 10000); // upper bound exclusive
        }

        // چاپ تعداد تولیدشده برای اطمینان
        System.out.println("Generated " + COUNT + " four-digit numbers.");

        // چاپ سه عدد اول (در صورتی که حداقل سه عدد تولید شده باشد)
        if (numbers.length >= 3) {
            System.out.println("First three numbers: " + numbers[0] + " " + numbers[1] + " " + numbers[2]);
        } else {
            System.out.println("Less than three numbers were generated.");
        }

        // بررسی سریع اینکه همهٔ مقادیر در بازهٔ 1000 تا 9999 هستند (اختیاری)
        boolean allInRange = true;
        for (int n : numbers) {
            if (n < 1000 || n > 9999) {
                allInRange = false;
                break;
            }
        }
        if (!allInRange) {
            System.err.println("Warning: Some generated numbers are out of the 4-digit range!");
        }
    }
}

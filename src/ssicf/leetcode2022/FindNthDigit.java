package ssicf.leetcode2022;

public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigitSolution s = new FindNthDigitSolution();
        int result = s.findNthDigit(100);
        System.out.println(result);
    }
}

class FindNthDigitSolution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
package ssicf.leetcode2022;

public class ConsecutiveNumbersSum {
  public static void main(String[] args) {
    ConsecutiveNumbersSumSolution s = new ConsecutiveNumbersSumSolution();
    int result = s.consecutiveNumbersSum(5);
    System.out.println(result);
  }
}

class ConsecutiveNumbersSumSolution {
  public int consecutiveNumbersSum(int n) {
    int ans = 0; n *= 2;
    int a = (int) Math.pow(n,0.5);
    for (int k = 1; k < a ; k++) {
      if (n % k != 0) continue;
      if ((n / k - (k - 1)) % 2 == 0) ans++;
    }
    return ans;
  }
}

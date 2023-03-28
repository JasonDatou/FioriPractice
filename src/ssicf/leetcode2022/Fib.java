package ssicf.leetcode2022;

public class Fib {
  public static void main(String[] args) {
    FibSolution s = new FibSolution();
    int result = s.fib(48);
    System.out.println(result);
  }
}

class FibSolution {
  public int fib(int n) {
    int[] res = new int[n + 1];
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else {
      res[0] = 0;
      res[1] = 1;
      for (int i = 2; i <= n; i++) {
        res[i] = (res[i - 1] + res[i - 2]) % 1000000007;
      }
      return res[n];
    }
  }
}
//1000000007
//1000000008
//512559680
//807526948

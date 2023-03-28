package ssicf.leetcode2022;

public class PowXN {
  public static void main(String[] args) {
    PowXNSolution s = new PowXNSolution();
    double result = s.myPow(2, -2147483648);
    System.out.println(result);
  }
}

class PowXNSolution {
  public double myPow(double x, int n) {
    return n < 0 ? myPow2(1 / x, -(long) n) : myPow2(x, n);
  }

  public double myPow2(double x, long n) {
    if (n == 0)
      return 1;
    else if (n == 1)
      return x;
    else {
      double half = myPow2(x, n / 2);
      return half * half * myPow2(x, n % 2);
    }
  }
}


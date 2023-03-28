package ssicf.leetcode2022;

public class CuttingRope {
  public static void main(String[] args) {
    CuttingRopeSolution s = new CuttingRopeSolution();
    int result = s.cuttingRope(10);
    System.out.println(result);
  }
}

class CuttingRopeSolution {
  public int cuttingRope(int n) {
    if (n <= 3) return n - 1;
    int a = n / 3, b = n % 3;
    if (b == 0) return (int) Math.pow(3, a);
    if (b == 1) return (int) Math.pow(3, a - 1) * 4;
    return (int) Math.pow(3, a) * 2;
  }
}

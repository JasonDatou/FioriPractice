package ssicf.leetcode2022;

public class SqrtX {
  public static void main(String[] args) {
    SqrtXSolution s = new SqrtXSolution();
    int result = s.mySqrt(8);
    System.out.println(result);
  }
}

class SqrtXSolution {
  public int mySqrt(int x) {
    long c = x;
    while (c * c > x) {
      c = (c + x / c) / 2;
    }
    return (int) c;
  }
}

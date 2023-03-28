package ssicf.leetcode2022;

public class PowerofTwo {
  public static void main(String[] args){
    PowerofTwoSolution s = new PowerofTwoSolution();
    boolean result = s.isPowerOfTwo(3);
    System.out.println(result);
  }
}

class PowerofTwoSolution {
  public boolean isPowerOfTwo(int n) {
    return (n & (n-1)) == 0;
  }
}

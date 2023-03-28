package ssicf.leetcode2022;

public class ClimbingStairs {
  public static void main(String[] args) {
    ClimbingStairsSolution s = new ClimbingStairsSolution();
    int result = s.climbStairs(1);
    System.out.println(result);
  }
}

class ClimbingStairsSolution {
  public int climbStairs(int n) {
    int[] res = new int[n];
    if(n==1)
      return 1;
    res[0] = 1;
    res[1] = 2;
    for (int i = 2; i < n; i++) {
      res[i] = res[i - 1] + res[i - 2];
    }
    return res[n -1];
  }
}

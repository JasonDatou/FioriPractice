package ssicf.leetcode2022;

public class NumWays {
  public static void main(String[] args) {
    NumWaysSolution s = new NumWaysSolution();
    int result = s.numWays(7);
    System.out.println(result);
  }
}

class NumWaysSolution {
  public int numWays(int n) {
    int[] res = new int[n + 1];
    if (n == 0)
      return 1;
    else if (n == 1)
      return 1;
    else if (n == 2)
      return 2;
    else {
      res[0] = 0;
      res[1] = 1;
      res[2] = 2;
      for (int i = 3; i <= n; i++) {
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

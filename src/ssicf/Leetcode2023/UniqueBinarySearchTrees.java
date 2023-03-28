package ssicf.Leetcode2023;

import java.util.List;
import ssicf.commons.TreeNode;

public class UniqueBinarySearchTrees {
  public static void main(String[] args) {
    UniqueBinarySearchTreesSolution s = new UniqueBinarySearchTreesSolution();
    int result = s.numTrees(2);
    System.out.println(result);
  }
}

//1 -> 1
//2 -> 2
//3 -> 5
//G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
//f(i)=G(i−1)∗G(n−i)
//G(n)=G(0)∗G(n−1) + G(1)∗(n−2)+...+G(n−1)∗G(0)
// G(0) = 1
// G(1) = 1
// G(2) = G(0)*G(1) + G(1)*G(0) = 1 + 1 = 2
// G(3) = 1
class UniqueBinarySearchTreesSolution {
  public int numTrees(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i-j-1];
      }
    }
    return dp[n];
  }
}

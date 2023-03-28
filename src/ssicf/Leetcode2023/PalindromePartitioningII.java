package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {
  public static void main(String[] args) {
    PalindromePartitioningIISolution s = new PalindromePartitioningIISolution();
    int result = s.minCut("aab");
    System.out.println(result);
  }
}

class PalindromePartitioningIISolution {
  List<String> temp = new ArrayList<>();
  int res = Integer.MAX_VALUE;

  public int minCut(String s) {
    backtrack(s);
    return res - 1;
  }

  void backtrack(String s) {
    if (s.length() == 0) {
      res = Math.min(res, temp.size());
      return;
    }
    for (int i = 1; i <= s.length(); i++) {
      String str = s.substring(0, i);
      if (isPalin(str)) {
        temp.add(str);
        backtrack(s.substring(i));
        temp.remove(temp.size() - 1);
      }
    }

  }

  boolean isPalin(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1))
        return false;
    }
    return true;
  }
}
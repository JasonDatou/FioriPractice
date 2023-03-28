package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterleavingString {
  public static void main(String[] args) {
    InterleavingStringSolution s = new InterleavingStringSolution();
    boolean result = s.isInterleave("aabcc", "dbbca", "aadbbcbcac");
//    boolean result = s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
//        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
//        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
//    boolean result = s.isInterleave("a", "b", "a");
    System.out.println(result);
  }
}

class InterleavingStringSolution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    if (m + n != s3.length())
      return false;
    for (int i = 1; i <= m; i++) {
      dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
    }
    for (int j = 1; j <= n; j++) {
      dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
      }
    }
    return dp[m][n];
  }
}
//
//  0 1 2 3 4 .. i .. m
//0 1 1
//1 0
//2
//3
//..
//j
//..
//n

//  !!Overdue!!!  Solution 2
//class Solution {
//  public boolean isInterleave(String s1, String s2, String s3) {
//    if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty())
//      return true;
//    if(s3.isEmpty())
//      return false;
//    return
//        ( !s1.isEmpty() &&
//            s1.charAt(0) == s3.charAt(0) &&
//            isInterleave(s1.substring(1), s2, s3.substring(1))) ||
//            ( !s2.isEmpty() &&
//                s2.charAt(0) == s3.charAt(0) &&
//                isInterleave(s1, s2.substring(1), s3.substring(1)));
//  }
//}

//  !!!Wrong!!!   Solution 1
//  public boolean isInterleave(String s1, String s2, String s3) {
//    int s1index = 0;
//    int s2index = 0;
//    for (int i = 0; i < s3.length(); i++) {
//      if (s1index < s1.length() && s1.charAt(s1index) == s3.charAt(i)) {
//        s1index++;
//        continue;
//      }
//      if (s2index < s2.length() && s2.charAt(s2index) == s3.charAt(i)) {
//        s2index++;
//        continue;
//      }
//      return false;
//    }
//    return s1index == s1.length() && s2index == s2.length();
//  }
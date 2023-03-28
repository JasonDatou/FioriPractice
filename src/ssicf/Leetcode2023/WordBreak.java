package ssicf.Leetcode2023;

import java.util.List;

public class WordBreak {
  public static void main(String[] args) {
    WordBreakSolution s = new WordBreakSolution();
    boolean result = s.wordBreak("leetcode",
        List.of("leet", "code"));
    System.out.println(result);
  }
}

class WordBreakSolution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (String word : wordDict) {
        int l = word.length();
        if (l <= i && s.substring(i - l, i).equals(word))
          dp[i] = dp[i - l] || dp[i];
      }
    }
    return dp[n];
  }
}
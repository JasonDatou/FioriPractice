package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  public static void main(String[] args) {
    PalindromePartitioningSolution s = new PalindromePartitioningSolution();
    List<List<String>> result = s.partition("a");
    System.out.println(result);
  }
}

class PalindromePartitioningSolution {
  List<List<String>> result = new ArrayList<>();
  List<String> temp = new ArrayList<>();

  public List<List<String>> partition(String s) {
    backtrack(s);
    return result;
  }

  void backtrack(String s) {
    if (s.length() == 0) {
      result.add(new ArrayList<>(temp));
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
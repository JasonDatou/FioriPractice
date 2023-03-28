package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.TreeNode;

public class ValidPalindrome {
  public static void main(String[] args) {
    ValidPalindromeSolution s = new ValidPalindromeSolution();
    boolean result = s.isPalindrome("0P");
    System.out.println(result);
  }
}

class ValidPalindromeSolution {
  public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (64 < c && c < 91)  // 65 -> 90  97 -> 122
        sb.append((char) (c + 32));
      else if ((96 < c && c < 123) || (47 < c && c < 58))  // 65 -> 90  97 -> 122
        sb.append(c);
    }
    return sb.toString().equals(sb.reverse().toString());
  }
}
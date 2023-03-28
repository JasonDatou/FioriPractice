package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
  public static void main(String[] args) {
    RemoveKDigitsSolution s = new RemoveKDigitsSolution();
    String result = s.removeKdigits("9", 1);
    System.out.println(result);
  }
}

class RemoveKDigitsSolution {
  public String removeKdigits(String num, int k) {
    StringBuilder sb = new StringBuilder();
    Deque<Integer> monostack = new ArrayDeque<>();

    for (int i = 0; i < num.length(); i++) {
      while (k > 0 && !monostack.isEmpty() && num.charAt(i) < num.charAt(monostack.peek())) {
        monostack.pop();
        k--;
      }
      monostack.push(i);
    }
    while (k > 0 && !monostack.isEmpty()) {
      monostack.pop();
      k--;
    }
    while (!monostack.isEmpty()) {
      sb.append(num.charAt(monostack.pop()));
    }
    String res = sb.reverse().toString().replaceFirst("^0*", "");
    if (res.isEmpty())
      return "0";
    else
      return res;
  }
}

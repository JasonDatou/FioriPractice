package ssicf.leetcode2022;

public class ReverseString {
  public static void main(String[] args) {
    ReverseStringSolution s = new ReverseStringSolution();
    char[] str = new char[]{'h', 'e', 'l', 'l', 'o'};
    s.reverseString(str);
    for (char c : str)
      System.out.print(c);
  }
}

class ReverseStringSolution {
  public void reverseString(char[] s) {
    char temp;
    for (int i = 0; i < s.length / 2; i++) {
      temp = s[i];
      s[i] = s[s.length - i - 1];
      s[s.length - i - 1] = temp;
    }
  }
}

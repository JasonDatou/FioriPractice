package ssicf.leetcode2022;

public class ReverseWords {
  public static void main(String[] args) {
    ReverseWordsSolution s = new ReverseWordsSolution();
    String result = s.reverseWords("Let's take LeetCode contest");
    System.out.println(result);
  }
}

class ReverseWordsSolution {
  public String reverseWords(String s) {
    int start = -1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ' ') {
        if (start == -1)
          start = i;
        if(i == s.length()-1){
          for (int j = i; j >= start; j--) {
            sb.append(s.charAt(j));
          }
          start = -1;
        }
      } else {
        for (int j = i - 1; j >= start; j--) {
          sb.append(s.charAt(j));
        }
        sb.append(s.charAt(i));
        start = -1;
      }
    }
    return sb.toString();
  }
}

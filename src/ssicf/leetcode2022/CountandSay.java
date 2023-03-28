package ssicf.leetcode2022;

public class CountandSay {
  public static void main(String[] args) {
    CountandSaySolution s = new CountandSaySolution();
    String result = s.countAndSay(5);
    System.out.println(result);
  }
}

class CountandSaySolution {
  public String countAndSay(int n) {
    return explain("1", 1, n);
  }

  String explain(String str, int deep, int target) {
    if (deep == target)
      return str;
    int count = 1;
    char c = str.charAt(0);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        count++;
      } else {
        sb.append(count).append(c);
        count = 1;
        c = str.charAt(i);
      }
    }
    sb.append(count).append(c);
    return explain(sb.toString(), deep + 1, target);
  }
}

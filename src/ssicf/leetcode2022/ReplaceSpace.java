package ssicf.leetcode2022;

public class ReplaceSpace {
  public static void main(String[] args) {
    ReplaceSpaceSolution s = new ReplaceSpaceSolution();
    String result = s.replaceSpace("We are happy.");
    System.out.println(result);
  }
}

// A B C E
// S F C S
// A D E E

class ReplaceSpaceSolution {
  public String replaceSpace(String s) {
//    return s.replaceAll(" ", "%20");
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ')
        sb.append("%20");
      else
        sb.append(c);
    }
    return sb.toString();
  }
}

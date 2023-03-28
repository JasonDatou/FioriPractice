package ssicf.leetcode2022;

public class LengthofLastWord {
  public static void main(String[] args) {
    LengthofLastWordSolution s = new LengthofLastWordSolution();
    int result = s.lengthOfLastWord("HelloWorld");
    System.out.println(result);
  }
}

class LengthofLastWordSolution {
  public int lengthOfLastWord(String s) {
    int startIndex = s.length() - 1;
    while (startIndex >= 0) {
      if (s.charAt(startIndex) != ' ') {
        break;
      }
      startIndex--;
    }

    int endIndex = startIndex - 1;
    while (endIndex >= 0) {
      if (s.charAt(endIndex) == ' ')
        break;
      endIndex--;
    }
    return startIndex - endIndex;
  }
}

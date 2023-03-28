package ssicf.leetcode2022;

public class RemoveOutermostParentheses {
  public static void main(String[] args){
    RemoveOutermostParenthesesSolution s = new RemoveOutermostParenthesesSolution();
    String result = s.removeOuterParentheses("(()())(())(()(()))");
    System.out.println(result);
  }
}

class RemoveOutermostParenthesesSolution {
  public String removeOuterParentheses(String s) {
    char[] cs = s.toCharArray();
    int n = cs.length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0, score = 0; i < n; ) {
      int j = i;
      while (i == j || score != 0) score += cs[j++] == '(' ? 1 : -1;
      sb.append(s.substring(i + 1, j - 1));
      i = j;
      score = 0;
    }
    return sb.toString();
  }
}


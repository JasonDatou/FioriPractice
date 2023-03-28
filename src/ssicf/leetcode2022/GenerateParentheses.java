package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public static void main(String[] args){
    GenerateParenthesesSolution s = new GenerateParenthesesSolution();
    List<String> result = s.generateParenthesis(3);
    System.out.println(result);
  }
}

class GenerateParenthesesSolution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    genParenthesis(result,"", 4, 4);
    return result;
  }

  private void genParenthesis(List<String> result, String str, int left, int right){
    if(left == 0 && right == 0){
      result.add(str);
      return;
    }
    if(left == right){
      genParenthesis(result, str + "(", left-1, right);
    }
    if(left < right){
      if(left > 0)
        genParenthesis(result, str + "(", left-1, right);
      genParenthesis(result, str + ")", left, right-1);
    }
  }
}

package ssicf.leetcode2022;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
  public static void main(String[] args){
    ValidParenthesesSolution s = new ValidParenthesesSolution();
    boolean result = s.isValid("()[]{[]}");
    System.out.println(result);
  }
}

class ValidParenthesesSolution {
  public boolean isValid(String s) {
    Map<Character,Character> parMap = new HashMap<>();
    parMap.put('(', ')');
    parMap.put('[', ']');
    parMap.put('{', '}');

    Deque<Character> stack = new LinkedList<Character>();
    for(int i=0; i<s.length(); i++){
      if(parMap.containsKey(s.charAt(i))){
        stack.push(s.charAt(i));
      }else{
        if(stack.isEmpty())
          return false;
        Character first = stack.getFirst();
        if(parMap.get(first).equals(s.charAt(i))){
          stack.pop();
        }else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

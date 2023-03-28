package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
  public static void main(String[] args) {
    ValidateStackSequencesSolution s = new ValidateStackSequencesSolution();
    int[] pushed = new int[]{1, 0};
    int[] popped = new int[]{1, 0};
    boolean result = s.validateStackSequences(pushed, popped);
    System.out.println(result);
  }
}

class ValidateStackSequencesSolution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Deque<Integer> stack = new ArrayDeque<>();
    int index = 0;
    for (int num : pushed) {
      stack.push(num);
      while (!stack.isEmpty() && popped[index] == stack.peek()) {
        stack.pop();
        index++;
      }
    }
    return stack.isEmpty();
  }
}

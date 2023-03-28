package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueueSolution {
  public static void main(String[] args) {
    CQueue obj = new CQueue();
    obj.appendTail(12);
    int param_2 = obj.deleteHead();
    param_2 = obj.deleteHead();
    System.out.println(param_2);
  }
}

class CQueue {
  Deque<Integer> stackA;
  Deque<Integer> stackB;

  public CQueue() {
    stackA = new ArrayDeque<>();
    stackB = new ArrayDeque<>();
  }

  public void appendTail(int value) {
    stackA.push(value);
  }

  public int deleteHead() {
    if (!stackB.isEmpty())
      return stackB.pop();
    while (!stackA.isEmpty()) {
      stackB.push(stackA.pop());
    }
    return stackB.isEmpty() ? -1 : stackB.pop();
  }
}

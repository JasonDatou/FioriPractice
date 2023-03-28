package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackTest {
  public static void main(String[] args){
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}

class MinStack {
  Deque<Integer> stack;
  Deque<Integer> minStack;

  public MinStack() {
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.peek() == null) {
      minStack.push(val);
    } else {
      minStack.push(Math.min(this.getMin(), val));
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}

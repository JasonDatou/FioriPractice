package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import ssicf.commons.ListNode;

public class ReversePrint {
  public static void main(String[] args) {
    ReversePrintSolution s = new ReversePrintSolution();
    ListNode c = new ListNode(2);
    ListNode b = new ListNode(3, c);
    ListNode a = new ListNode(1, b);
    int[] result = s.reversePrint(a);
    System.out.println(Arrays.toString(result));
  }
}


class ReversePrintSolution {
  public int[] reversePrint(ListNode head) {
    Deque<Integer> stack = new ArrayDeque<>();
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    int[] res = new int[stack.size()];
    int index = 0;
    while (!stack.isEmpty()) {
      res[index++] = stack.pop();
    }
    return res;
  }
}

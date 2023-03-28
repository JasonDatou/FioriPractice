package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class ReverseNodeList {
  public static void main(String[] args) {
    ReverseNodeListSolution s = new ReverseNodeListSolution();
    ListNode d = new ListNode(4);
    ListNode c = new ListNode(3, d);
    ListNode b = new ListNode(2, c);
    ListNode a = new ListNode(1, b);
    ListNode result = s.reverseList(c);
    System.out.println(result);
  }
}

class ReverseNodeListSolution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}

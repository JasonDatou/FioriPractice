package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class GetKthFromEnd {
  public static void main(String[] args) {
    GetKthFromEndSolution s = new GetKthFromEndSolution();
    ListNode d = new ListNode(4);
    ListNode c = new ListNode(3, d);
    ListNode b = new ListNode(2, c);
    ListNode a = new ListNode(1, b);
    ListNode result = s.getKthFromEnd(a, 2);
    System.out.println(result);
  }
}

class GetKthFromEndSolution {
  public ListNode getKthFromEnd(ListNode head, int k) {
    int n = 0;
    ListNode node = null;

    for (node = head; node != null; node = node.next) {
      n++;
    }
    for (node = head; n > k; n--) {
      node = node.next;
    }

    return node;
  }
}

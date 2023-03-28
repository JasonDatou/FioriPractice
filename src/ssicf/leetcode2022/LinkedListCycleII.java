package ssicf.leetcode2022;

import java.util.HashSet;
import java.util.Set;
import ssicf.commons.ListNode;

public class LinkedListCycleII {
  public static void main(String[] args) {
    LinkedListCycleIISolution s = new LinkedListCycleIISolution();
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(1, a);
    ListNode c = new ListNode(1, b);
    ListNode d = new ListNode(1, c);
//    a.next = c;

    ListNode result = s.detectCycle(d);
    System.out.println(result);
  }
}

class LinkedListCycleIISolution {
  public ListNode detectCycle(ListNode head) {
    Set<ListNode> nodes = new HashSet<>();
    ListNode curr = head;
    while (curr != null) {
      if (nodes.contains(curr))
        return curr;
      nodes.add(curr);
      curr = curr.next;
    }
    return null;
  }
}

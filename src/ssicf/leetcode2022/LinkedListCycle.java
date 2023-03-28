package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class LinkedListCycle {
  public static void main(String[] args){
    LinkedListCycleSolution s = new LinkedListCycleSolution();
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(1, a);
    ListNode c = new ListNode(1, b);
    ListNode d = new ListNode(1, c);
    a.next = c;

    boolean result = s.hasCycle(d);
    System.out.println(result);
  }
}

class LinkedListCycleSolution {
  public boolean hasCycle(ListNode head) {
    ListNode fake = new ListNode(0);
    while (head != null){
      if(head.next == fake)
        return true;
      ListNode next = head.next;
      head.next = fake;
      head = next;
    }
    return false;
  }
}

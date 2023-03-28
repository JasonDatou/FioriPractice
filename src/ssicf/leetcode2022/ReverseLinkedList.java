package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class ReverseLinkedList {
  public static void main(String[] args){

    ListNode b6 = new ListNode(6);
    ListNode b5 = new ListNode(5, b6);
    ListNode b4 = new ListNode(4, b5);
    ListNode b3 = new ListNode(3, b4);
    ListNode b2 = new ListNode(2, b3);
    ListNode b = new ListNode(1, b2);


    ReverseLinkedListSolution s = new ReverseLinkedListSolution();
    ListNode result = s.reverseList(b5);
    System.out.println(result);
  }
}

class ReverseLinkedListSolution {
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

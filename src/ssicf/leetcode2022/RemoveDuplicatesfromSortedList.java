package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class RemoveDuplicatesfromSortedList {
  public static void main(String[] args){
    ListNode e = new ListNode(3);
    ListNode d = new ListNode(3, e);
    ListNode c = new ListNode(2, d);
    ListNode b = new ListNode(1, c);
    ListNode a = new ListNode(1, b);

    RemoveDuplicatesfromSortedListSolution s = new RemoveDuplicatesfromSortedListSolution();
    ListNode result = s.deleteDuplicates(a);
    System.out.println(result);
  }
}

class RemoveDuplicatesfromSortedListSolution {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null)
      return null;
    ListNode root = head;
    while (true){
      if(root.next == null)
        break;
      if(root.val ==root.next.val){
        root.next = root.next.next;
      }else {
        root = root.next;
      }
    }
    return head;
  }
}

package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class RotateList {
  public static void main(String[] args) {
//    ListNode a = new ListNode(5);
//    ListNode b = new ListNode(4, a);
    ListNode c = new ListNode(2);
    ListNode d = new ListNode(1, c);
    ListNode e = new ListNode(0, d);

    RotateListSolution s = new RotateListSolution();
    ListNode result = s.rotateRight(c, 1);
    System.out.println(result);
  }
}

class RotateListSolution {
  public ListNode rotateRight(ListNode head, int k) {
    if(head == null)
      return null;
    ListNode res;
    int length = 0;
    ListNode pre = new ListNode(0, head);
    ListNode temp = pre;
    while (temp.next != null) {
      length++;
      temp = temp.next;
    }
    ListNode last = temp;

    int offset = length - k % length;
    if (offset == length)
      return head;

    temp = pre;
    while (offset > 0) {
      temp = temp.next;
      offset--;
    }
    res = temp.next;
    temp.next = null;
    last.next = head;
    return res;
  }
}

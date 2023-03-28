package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class DeleteNode {
  public static void main(String[] args) {
    DeleteNodeSolution s = new DeleteNodeSolution();
    ListNode input5 = new ListNode(5);
    ListNode input4 = new ListNode(4, input5);
    ListNode input3 = new ListNode(3, input4);
    ListNode input2 = new ListNode(2, input3);
    ListNode input1 = new ListNode(1, input2);
    ListNode res = s.deleteNode(input1, 5);
    System.out.println(res);
  }
}

class DeleteNodeSolution {
  public ListNode deleteNode(ListNode head, int val) {
    ListNode pre = new ListNode();
    pre.next = head;
    while (pre.next != null) {
      if (pre.next.val == val) {
        if (pre.next == head)
          return head.next;
        pre.next = pre.next.next;
        break;
      }
      pre = pre.next;
    }
    return head;
  }
}


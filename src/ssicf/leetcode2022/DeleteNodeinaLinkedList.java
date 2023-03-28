package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class DeleteNodeinaLinkedList {
  public static void main(String[] args) {
    DeleteNodeinaLinkedListSolution s = new DeleteNodeinaLinkedListSolution();
    ListNode input5 = new ListNode(5);
    ListNode input4 = new ListNode(4, input5);
    ListNode input3 = new ListNode(3, input4);
    ListNode input2 = new ListNode(2, input3);
    ListNode input1 = new ListNode(1, input2);
    s.deleteNode(input3);
    System.out.println(input1);
  }
}

class DeleteNodeinaLinkedListSolution {
  public void deleteNode(ListNode node) {
    node.val= node.next.val;
    node.next = node.next.next;
  }
}


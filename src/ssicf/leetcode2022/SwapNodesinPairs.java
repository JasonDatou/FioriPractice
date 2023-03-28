package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class SwapNodesinPairs {
  public static void main(String[] args){
    SwapNodesinPairsSolution s = new SwapNodesinPairsSolution();
    ListNode input5 = new ListNode(5);
    ListNode input4 = new ListNode(4, input5);
    ListNode input3 = new ListNode(3, input4);
    ListNode input2 = new ListNode(2, input3);
    ListNode input1 = new ListNode(1, input2);

    ListNode result = s.swapPairs(input4);
    System.out.println(result);
  }
}

class SwapNodesinPairsSolution {
  public ListNode swapPairs(ListNode head) {
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode temp = pre;
    while(temp.next != null && temp.next.next != null) {
      ListNode start = temp.next;
      ListNode end = temp.next.next;
      temp.next = end;
      start.next = end.next;
      end.next = start;
      temp = start;
    }
    return pre.next;
  }
}

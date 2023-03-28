package ssicf.Leetcode2023;

import ssicf.commons.ListNode;

public class PartitionList {
  public static void main(String[] args){
    PartitionListSolution s = new PartitionListSolution();
    ListNode input6 = new ListNode(2);
    ListNode input5 = new ListNode(5, input6);
    ListNode input4 = new ListNode(2, input5);
    ListNode input3 = new ListNode(3, input4);
    ListNode input2 = new ListNode(4, input3);
    ListNode input1 = new ListNode(1, input2);

    ListNode result = s.partition(input4, 3);
    System.out.println(result);
  }
}

class PartitionListSolution {
  public ListNode partition(ListNode head, int x) {
    ListNode smallori = null;
    ListNode small = null;
    ListNode bigori = null;
    ListNode big = null;

    while (head != null) {
      if(head.val < x) {
        if(small != null) {
          small.next = new ListNode(head.val);
          small = small.next;
        } else {
          small = new ListNode(head.val);
          smallori = small;
        }
      } else {
        if(big != null) {
          big.next = new ListNode(head.val);
          big = big.next;
        } else {
          big = new ListNode(head.val);
          bigori = big;
        }
      }
      head = head.next;
    }
    if (small != null) {
      small.next = bigori;
      return smallori;
    } else {
      return bigori;
    }
  }
}

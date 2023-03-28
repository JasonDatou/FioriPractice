package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.ListNode;

public class RemoveDuplicatesfromSortedListII {
  public static void main(String[] args) {
    RemoveDuplicatesfromSortedListIISolution s = new RemoveDuplicatesfromSortedListIISolution();
    ListNode head = new ListNode(new int[]{1, 1, 2, 3});
    ListNode result = s.deleteDuplicates(head);
    System.out.println(result);
  }
}

class RemoveDuplicatesfromSortedListIISolution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(-1, head);
    ListNode pre = dummyHead, cur = pre.next;
    while (cur != null) {
      ListNode next = cur.next;
      while (next != null && cur.val == next.val) {
        next = next.next;
      }
      if (next != cur.next) {
        //next 移动过，说明中间存在重复元素，将 pre 的 next 指针指向
        //当前的 next，这样就跳过了重复元素
        pre.next = next;
        cur = next;
      } else {
        //next 没有移动过，pre 和 cur 向后移动一位
        pre = cur;
        cur = next;
      }
    }
    return dummyHead.next;
  }
}
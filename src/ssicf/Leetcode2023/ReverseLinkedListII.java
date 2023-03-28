package ssicf.Leetcode2023;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import ssicf.commons.ListNode;

public class ReverseLinkedListII {
  public static void main(String[] args) {
    ReverseLinkedListIISolution s = new ReverseLinkedListIISolution();
    ListNode head = new ListNode("1,2,3,4,5");
    ListNode result = s.reverseBetween(head, 2, 4);
    System.out.println(result);
  }
}

class ReverseLinkedListIISolution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;

    ListNode pre = dummyNode;
    // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
    // 建议写在 for 循环里，语义清晰
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }
    ListNode leftNode = pre.next;


    // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
    ListNode rightNode = pre;
    for (int i = 0; i < right - left + 1; i++) {
      rightNode = rightNode.next;
    }

    // 第 3 步：切断出一个子链表（截取链表）
    ListNode curr = rightNode.next;

    // 注意：切断链接
    pre.next = null;
    rightNode.next = null;

    // 第 4 步：同第 206 题，反转链表的子区间
    reverseList(leftNode);

    // 第 5 步：接回到原来的链表中
    pre.next = rightNode;
    leftNode.next = curr;
    return dummyNode.next;
  }

  public void reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
  }
}

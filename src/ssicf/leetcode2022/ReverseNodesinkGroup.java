package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class ReverseNodesinkGroup {
  public static void main(String[] args){
    ListNode b6 = new ListNode(6);
    ListNode b5 = new ListNode(5, b6);
    ListNode b4 = new ListNode(4, b5);
    ListNode b3 = new ListNode(3, b4);
    ListNode b2 = new ListNode(2, b3);
    ListNode b = new ListNode(1, b2);

    ReverseNodesinkGroupSolution s = new ReverseNodesinkGroupSolution();
    ListNode result = s.reverseKGroup(b,2);
//    ListNode tail = b;
//    s.reverseList(b);

    System.out.println(result);
  }
}

class ReverseNodesinkGroupSolution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode hair = new ListNode(0);
    hair.next = head;
    ListNode pre = hair;

    while (head != null) {
      ListNode tail = pre;
      // 查看剩余部分长度是否大于等于 k
      for (int i = 0; i < k; ++i) {
        tail = tail.next;
        if (tail == null) {
          return hair.next;
        }
      }
      ListNode nex = tail.next;
      ListNode[] reverse = myReverse(head, tail);
      head = reverse[0];
      tail = reverse[1];
      // 把子链表重新接回原链表
      pre.next = head;
      tail.next = nex;
      pre = tail;
      head = tail.next;
    }

    return hair.next;
  }

  public ListNode[] myReverse(ListNode head, ListNode tail) {
    ListNode prev = tail.next;
    ListNode p = head;
    while (prev != tail) {
      ListNode nex = p.next;
      p.next = prev;
      prev = p;
      p = nex;
    }
    return new ListNode[]{tail, head};
  }

//  public ListNode reverseList(ListNode head, ListNode tail) {
//    ListNode prev = null;
//    ListNode curr = head;
//    while (curr != tail) {
//      ListNode next = curr.next;
//      curr.next = prev;
//      prev = curr;
//      curr = next;
//    }
//    return prev;
//  }
//
//  public ListNode getNodeByIndex(ListNode head, int index){
//    ListNode temp = head;
//    for(int i=0; i<index; i++){
//      if(temp.next != null)
//        temp = temp.next;
//      else
//        return null;
//    }
//    return temp;
//  }
}

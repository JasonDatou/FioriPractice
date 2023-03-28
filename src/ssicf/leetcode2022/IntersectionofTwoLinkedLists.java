package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class IntersectionofTwoLinkedLists {
  public static void main(String[] args){
    ListNode a4 = new ListNode(44);
    ListNode a3 = new ListNode(33, a4);
    ListNode a2 = new ListNode(22, a3);
    ListNode a1 = new ListNode(11, a2);

    ListNode b2 = new ListNode(88, a3);
    ListNode b1 = new ListNode(99, b2);


    IntersectionofTwoLinkedListsSolution s = new IntersectionofTwoLinkedListsSolution();
    ListNode result = s.getIntersectionNode(a4, a4);
    System.out.println(result);
  }
}

class IntersectionofTwoLinkedListsSolution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }
}

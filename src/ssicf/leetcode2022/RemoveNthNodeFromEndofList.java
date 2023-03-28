package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class RemoveNthNodeFromEndofList {
  public static void main(String[] args) {
    RemoveNthNodeFromEndofListSolution s = new RemoveNthNodeFromEndofListSolution();
    ListNode input5 = new ListNode(5);
    ListNode input4 = new ListNode(4, input5);
    ListNode input3 = new ListNode(3, input4);
    ListNode input2 = new ListNode(2, input3);
    ListNode input1 = new ListNode(1, input2);
    ListNode result = s.removeNthFromEnd(input5, 1);
    System.out.println(result.toString());
  }
}

class RemoveNthNodeFromEndofListSolution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int length = getLength(head);
    ListNode currNode = new ListNode(0, head);
    ListNode initialNode = currNode;
    int position = length - n;
    for(int i=0; i<position; i++){
      currNode = currNode.next;
    }
    currNode.next = currNode.next.next;
    return initialNode.next;
  }

  int getLength(ListNode head) {
    int length = 0;
    ListNode nextNode = head;
    while (nextNode != null) {
      length++;
      nextNode = nextNode.next;
    }
    return length;
  }

}


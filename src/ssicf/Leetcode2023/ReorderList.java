package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.ListNode;

public class ReorderList {
  public static void main(String[] args) {
    ReorderListSolution s = new ReorderListSolution();
    ListNode head = new ListNode("1,2,3,4,5");
    s.reorderList(head);
    System.out.println(head);
  }
}

class ReorderListSolution {
  public void reorderList(ListNode head) {
    List<ListNode> nodes = convertToList(head);
    int n = nodes.size();
    for (int i = 0; i < n / 2; i++) {
      nodes.get(i).next = nodes.get(n - i - 1);
    }
    for (int i = n - 1; i > n / 2; i--) {
      nodes.get(i).next = nodes.get(n - i);
    }
    nodes.get(n / 2).next = null;
  }

  List<ListNode> convertToList(ListNode head) {
    List<ListNode> nodes = new ArrayList<>();
    while (head != null) {
      nodes.add(head);
      head = head.next;
    }
    return nodes;
  }
}
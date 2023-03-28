package ssicf.leetcode2022;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
  public static void main(String[] args) {
    CopyRandomListSolution s = new CopyRandomListSolution();
    Node head = new Node(7);
    Node a = new Node(13);
    Node b = new Node(11);
    Node c = new Node(10);
    Node d = new Node(1);
    head.next = a;
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = null;
    Node result = s.copyRandomList(head);
    System.out.println(result);
  }
}

class CopyRandomListSolution {
  Map<Node, Node> map = new HashMap<>();

  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    if (!map.containsKey(head)) {
      Node node = new Node(head.val);
      map.put(head, node);
      node.next = copyRandomList(head.next);
      node.random = copyRandomList(head.random);
      return node;
    }
    return map.get(head);
  }
}

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }


}

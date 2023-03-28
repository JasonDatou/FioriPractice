package ssicf.leetcode2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CopyListwithRandomPointer {
  public static void main(String[] args) {
    CopyListwithRandomPointerSolution s = new CopyListwithRandomPointerSolution();
    Node head = new Node(7);
    Node a = new Node(13);
    Node b = new Node(11);
    Node c = new Node(10);
    Node d = new Node(1);
    head.next = a;
    head.random = null;
    a.next = b;
    a.random = head;
    b.next = c;
    b.random = d;
    c.next = d;
    c.random = b;
    d.next = null;
    d.random = head;
    Node result = s.copyRandomList(head);
    System.out.println(result);
  }
}

class CopyListwithRandomPointerSolution {
  Map<Node, Node> copied = new HashMap<>();

  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    if (copied.containsKey(head))
      return copied.get(head);
    Node node = new Node(head.val);
    copied.put(head, node);
    node.next = copyRandomList(head.next);
    node.random = copyRandomList(head.random);
    return node;
  }
}
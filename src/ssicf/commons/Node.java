package ssicf.commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }

  public Node(String str) {
    String[] strs = str.split(",");
    List<Integer> vals = new ArrayList<>();
    for (String s : strs) {
      if (!"null".equals(s))
        vals.add(Integer.parseInt(s));
      else
        vals.add(Integer.MIN_VALUE);
    }
    this.val = vals.get(0);
    build(vals, Collections.singletonList(this), 1);
  }

  //        0->0->2^0-1
  //        1 2->1->2^1-1,2^2
  //        3 4 5 6->2->2^2-1 2^2

  private static void build(List<Integer> list, List<Node> lastLevel, int lastsize) {
    if (lastLevel.isEmpty())
      return;
    // 0 -> 0->0 2^0-1
    // 1 -> 1->2 2^1-1
    // 2 -> 3->6
    // 3 -> 7-12
    int startIndex = 2 * lastsize - 1;
    int endIndex = Math.min(startIndex * 2, list.size() - 1);
    List<Node> nextLevel = new ArrayList<>();
    for (int i = startIndex; i <= endIndex; i++) {
      Node temp = null;
      if (list.get(i) != null && list.get(i) != Integer.MIN_VALUE) {
        temp = new Node(list.get(i));
        nextLevel.add(temp);
      } else {
        continue;
      }
      if ((i - startIndex) % 2 == 0)
        lastLevel.get((i - startIndex) / 2).left = temp;
      else
        lastLevel.get((i - startIndex) / 2).right = temp;
    }
    build(list, nextLevel, lastsize * 2);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    List<Node> printList = new ArrayList<>();
    printList.add(this);
    wfs(sb, printList);
    return sb.toString();
  }

  private void wfs(StringBuilder sb, List<Node> printList) {
    boolean isEnd = true;
    List<Node> printListNext = new ArrayList<>();
    for (Node treeNode : printList) {
      if (treeNode == null) {
        sb.append("null,");
        printListNext.add(null);
        printListNext.add(null);
      } else {
        sb.append(treeNode.val).append(',');
        printListNext.add(treeNode.left);
        printListNext.add(treeNode.right);
        if (treeNode.left != null || treeNode.right != null)
          isEnd = false;
      }
    }
    if (!isEnd)
      wfs(sb, printListNext);
  }
}
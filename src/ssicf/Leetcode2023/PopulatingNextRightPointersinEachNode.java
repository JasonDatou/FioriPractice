package ssicf.Leetcode2023;

import java.util.ArrayDeque;
import java.util.Queue;
import ssicf.commons.Node;

public class PopulatingNextRightPointersinEachNode {
  public static void main(String[] args) {
    PopulatingNextRightPointersinEachNodeSolution s = new PopulatingNextRightPointersinEachNodeSolution();
    Node root = new Node("1,2,3,4,5,6,7");
    Node result = s.connect(root);
    System.out.println(result);
  }
}

class PopulatingNextRightPointersinEachNodeSolution {
  public Node connect(Node root) {
    bfs(root);
    return root;
  }

  void bfs(Node root) {
    if (root == null)
      return;
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      Node pre = null;
      for (int i = 0; i < n; i++) {
        Node node = queue.poll();
        if (pre != null)
          pre.next = node;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        pre = node;
      }
    }
  }
}
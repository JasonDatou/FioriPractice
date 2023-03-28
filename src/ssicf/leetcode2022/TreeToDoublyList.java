package ssicf.leetcode2022;

public class TreeToDoublyList {
  public static void main(String[] args) {
    TreeToDoublyListSolution s = new TreeToDoublyListSolution();

    NodeLR ll = new NodeLR(1);
    NodeLR lr = new NodeLR(3);
    NodeLR l = new NodeLR(2, ll, lr);

    NodeLR r = new NodeLR(5);
    NodeLR root = new NodeLR(4, l, r);

    NodeLR result = s.treeToDoublyList(root);
    System.out.println(result);
  }
}

class TreeToDoublyListSolution {
  NodeLR pre = null, head = null;

  public NodeLR treeToDoublyList(NodeLR root) {
    if (root == null) return root;
    dfs(root);
    head.left = pre;
    pre.right = head;
    return head;
  }

  void dfs(NodeLR root) {
    if (root == null)
      return;
    dfs(root.left);
    if (pre != null)
      pre.right = root;
    else
      head = root;
    pre = root;
//    System.out.println(root.val);
    dfs(root.right);
  }
}


class NodeLR {
  public int val;
  public NodeLR left;
  public NodeLR right;

  public NodeLR() {
  }

  public NodeLR(int _val) {
    val = _val;
  }

  public NodeLR(int _val, NodeLR _left, NodeLR _right) {
    val = _val;
    left = _left;
    right = _right;
  }
};

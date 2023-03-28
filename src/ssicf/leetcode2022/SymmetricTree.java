package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.TreeNode;

public class SymmetricTree {
  public static void main(String[] args) {
    SymmetricTreeSolution s = new SymmetricTreeSolution();
    TreeNode c4 = new TreeNode(3);
    TreeNode c3 = new TreeNode(5);
    TreeNode c2 = new TreeNode(5);
    TreeNode c1 = new TreeNode(4);

    TreeNode c = new TreeNode(2, c3, c4);
    TreeNode b = new TreeNode(2, c1, c2);
    TreeNode head = new TreeNode(1, b, c);

    boolean result = s.isSymmetric(head);
    System.out.println(result);
  }
}

class SymmetricTreeSolution {
  public boolean isSymmetric(TreeNode root) {
    List<TreeNode> nodes = new ArrayList<>();
    nodes.add(root);
    return isSymmetricList(nodes);
  }

  private boolean isSymmetricList(List<TreeNode> nodes) {
    int n = nodes.size();
    List<TreeNode> nodesNext = new ArrayList<>();
    boolean isAllNull = true;
    for (int i = 0; i < n / 2; i++) {
      String left = nodes.get(i) == null ? "null" : String.valueOf(nodes.get(i).val);
      String right = nodes.get(n - i - 1) == null ? "null" : String.valueOf(nodes.get(n - i - 1).val);
      if (!left.equals(right))
        return false;
    }

    for (TreeNode node : nodes) {
      if (node != null)
        isAllNull = false;
      nodesNext.add(node == null ? null : node.left);
      nodesNext.add(node == null ? null : node.right);
    }
    if (isAllNull)
      return true;
    else
      return isSymmetricList(nodesNext);

  }
}

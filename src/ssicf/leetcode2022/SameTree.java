package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class SameTree {
  public static void main(String[] args) {
    TreeNode al = new TreeNode(11);
    TreeNode ar = new TreeNode(22);
    TreeNode a = new TreeNode(1, al, ar);

    TreeNode bl = new TreeNode(11);
    TreeNode br = new TreeNode(23);
    TreeNode b = new TreeNode(1, bl, br);

    SameTreeSolution s = new SameTreeSolution();
    boolean result = s.isSameTree(a, b);
    System.out.println(result);
  }
}

class SameTreeSolution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null)
      return true;
    else if (p == null || q == null)
      return false;
    else
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}

package ssicf.leetcode2022;

import java.util.Arrays;
import ssicf.commons.TreeNode;

public class IsSymmetric {
  public static void main(String[] args) {
    IsSymmetricSolution s = new IsSymmetricSolution();
    TreeNode input = new TreeNode("1, 2, 2, 3, 4, 4, 3");
    boolean result = s.isSymmetric(input);
    System.out.println(result);
  }
}

class IsSymmetricSolution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return check(root.left, root.right);
  }

  public boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null)
      return true;
    if (p == null || q == null)
      return false;
    return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
  }
}

package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class UnivaluedBinaryTree {
  public static void main(String[] args) {
    TreeNode a = new TreeNode(1);
    TreeNode b = new TreeNode(1, null, null);
    TreeNode c = new TreeNode(1, a, null);
    TreeNode d = new TreeNode(1, b, c);

    UnivaluedBinaryTreeSolution s = new UnivaluedBinaryTreeSolution();
    boolean result = s.isUnivalTree(d);
    System.out.println(result);
  }
}

class UnivaluedBinaryTreeSolution {
  int value;
  public boolean isUnivalTree(TreeNode root) {
    value = root.val;
    return isUnival(root);

  }

  private boolean isUnival(TreeNode root) {
    if(root == null)
      return true;
    return root.val == value  && isUnival(root.left) && isUnival(root.right);
  }
}

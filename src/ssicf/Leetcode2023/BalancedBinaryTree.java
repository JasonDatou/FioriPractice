package ssicf.Leetcode2023;

import ssicf.commons.TreeNode;

public class BalancedBinaryTree {
  public static void main(String[] args) {
    BalancedBinaryTreeSolution s = new BalancedBinaryTreeSolution();
    TreeNode treeNode = new TreeNode("3,9,20,null,null,15,7");
    System.out.println(treeNode);
    Boolean result = s.isBalanced(treeNode);
    System.out.println(result);
  }
}

class BalancedBinaryTreeSolution {
  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;
    return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
  }

  private int height(TreeNode node) {
    if (node == null)
      return 1;
    return Math.max(height(node.left), height(node.right)) + 1;
  }
}
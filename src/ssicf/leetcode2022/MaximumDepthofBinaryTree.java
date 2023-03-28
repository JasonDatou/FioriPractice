package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class MaximumDepthofBinaryTree {
  public static void main(String[] args) {
    TreeNode a = new TreeNode(2);
    TreeNode b = new TreeNode(1, null, a);
    TreeNode c = new TreeNode(4);
    TreeNode head = new TreeNode(3, b, c);

    MaximumDepthofBinaryTreeSolution s = new MaximumDepthofBinaryTreeSolution();
    int result = s.maxDepth(head);
    System.out.println(result);
  }
}

class MaximumDepthofBinaryTreeSolution {
  public int maxDepth(TreeNode root) {
    if(root == null)
      return 0;
    else
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}

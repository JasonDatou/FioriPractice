package ssicf.Leetcode2023;

import java.util.Arrays;
import ssicf.commons.TreeNode;

public class MinimumDepthofBinaryTree {
  public static void main(String[] args) {
    MinimumDepthofBinaryTreeSolution s = new MinimumDepthofBinaryTreeSolution();
//    TreeNode root4 = new TreeNode(6, null, null);
//    TreeNode root3 = new TreeNode(5, root4, null);
//    TreeNode root2 = new TreeNode(4, root3, null);
//    TreeNode root1 = new TreeNode(3, root2, null);
//    TreeNode root = new TreeNode(2, root1, null);
    TreeNode root = new TreeNode("1,2,3,4,5,null,null");
    int result = s.minDepth(root);
    System.out.println(result);
  }
}

class MinimumDepthofBinaryTreeSolution {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    else if (root.left == null)
      return minDepth(root.right) + 1;
    else if (root.right == null)
      return minDepth(root.left) + 1;
    else
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
package ssicf.Leetcode2023;

import ssicf.commons.TreeNode;

public class PathSum {
  public static void main(String[] args) {
    PathSumSolution s = new PathSumSolution();
//    TreeNode root = new TreeNode("5,4,8,11,null,13,4,7,2,null,null,null,1");
    TreeNode root = new TreeNode("1");
    boolean result = s.hasPathSum(root, 1);
    System.out.println(result);
  }
}

class PathSumSolution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return sum == root.val;
    }
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }
}

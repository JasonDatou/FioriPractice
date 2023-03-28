package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class SumofRootToLeafBinaryNumbers {
  public static void main(String[] args) {
    TreeNode b4 = new TreeNode(1);
    TreeNode b3 = new TreeNode(0);
    TreeNode b2 = new TreeNode(1);
    TreeNode b1 = new TreeNode(0);
    TreeNode a2 = new TreeNode(1, b3, b4);
    TreeNode a1 = new TreeNode(0, b1, b2);
    TreeNode head = new TreeNode(1, a1, a2);

    SumofRootToLeafBinaryNumbersSolution s = new SumofRootToLeafBinaryNumbersSolution();
    int result = s.sumRootToLeaf(head);
    System.out.println(result);
  }
}

class SumofRootToLeafBinaryNumbersSolution {
  public int sumRootToLeaf(TreeNode root) {
    return dfs(root, 0);
  }

  int dfs(TreeNode root, int val) {
    if (root == null) {
      return 0;
    }
    val = val * 2 + root.val;
    if (root.left == null && root.right == null) {
      return val;
    }
    return dfs(root.left, val) + dfs(root.right, val);
  }
}

package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
  public static void main(String[] args) {
    LowestCommonAncestorofaBinaryTreeSolution s = new LowestCommonAncestorofaBinaryTreeSolution();

    TreeNode b21 = new TreeNode(7);
    TreeNode b22 = new TreeNode(4);
    TreeNode b1 = new TreeNode(6);
    TreeNode b2 = new TreeNode(2, b21, b22);
    TreeNode b = new TreeNode(5, b1, b2);

    TreeNode c1 = new TreeNode(0);
    TreeNode c2 = new TreeNode(8);
    TreeNode c = new TreeNode(1, c1, c2);
    TreeNode head = new TreeNode(3, b, c);

    TreeNode result = s.lowestCommonAncestor(head, b, c);
    System.out.println(result);
  }
}

class LowestCommonAncestorofaBinaryTreeSolution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null && right == null) return null; // 1.
    if (left == null) return right; // 3.
    if (right == null) return left; // 4.
    return root; // 2. if(left != null and right != null)
  }
}

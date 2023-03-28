package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {
  public static void main(String[] args) {
    LowestCommonAncestorofaBinarySearchTreeSolution s = new LowestCommonAncestorofaBinarySearchTreeSolution();
//    TreeNode aa = new TreeNode(1);
//    TreeNode bb = new TreeNode(1);
//    TreeNode b = new TreeNode(11, aa, bb);
    TreeNode c = new TreeNode(22);
    TreeNode head = new TreeNode(111, c, null);

    TreeNode result = s.lowestCommonAncestor(head, c, head);
    System.out.println(result);
  }
}

class LowestCommonAncestorofaBinarySearchTreeSolution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val < p.val && root.val < q.val)
      return lowestCommonAncestor(root.right, p, q);
    if (root.val > p.val && root.val > q.val)
      return lowestCommonAncestor(root.left, p, q);
    return root;
  }
}

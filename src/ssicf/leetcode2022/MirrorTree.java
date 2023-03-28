package ssicf.leetcode2022;

import java.util.Arrays;
import ssicf.commons.TreeNode;

public class MirrorTree {
  public static void main(String[] args) {
    MirrorTreeSolution s = new MirrorTreeSolution();
    TreeNode input = new TreeNode("4, 2, 7, 1, 3, 6, 9");
    TreeNode result = s.mirrorTree(input);
    System.out.println(result);
  }
}

class MirrorTreeSolution {
  public TreeNode mirrorTree(TreeNode root) {
    swap(root);
    return root;
  }

  private void swap(TreeNode node) {
    if (node == null)
      return;
    TreeNode temp = node.left;
      node.left = node.right;
    node.right = temp;
    if (node.left != null)
      swap(node.left);
    if (node.right != null)
      swap(node.right);
  }
}

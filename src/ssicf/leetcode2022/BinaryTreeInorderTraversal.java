package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.TreeNode;

public class BinaryTreeInorderTraversal {
  public static void main(String[] args) {
    BinaryTreeInorderTraversalSolution s = new BinaryTreeInorderTraversalSolution();
    TreeNode c = new TreeNode(3);
    TreeNode b = new TreeNode(2, c, null);
    TreeNode head = new TreeNode(1, null, b);

    List<Integer> result = s.inorderTraversal(head);
    System.out.println(result);
  }
}

class BinaryTreeInorderTraversalSolution {
  List<Integer> res = new ArrayList<>();
  public List<Integer> inorderTraversal(TreeNode root) {
    inorder(root);
    return res;
  }

  void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    res.add(root.val);
    inorder(root.right);
  }
}

package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.ListNode;
import ssicf.commons.TreeNode;

public class BinaryTreePreorderTraversal {
  public static void main(String[] args) {
    BinaryTreePreorderTraversalSolution s = new BinaryTreePreorderTraversalSolution();
    TreeNode head = new TreeNode("1,null,2,3");
    List<Integer> res = s.preorderTraversal(head);
    System.out.println(res);
  }
}

class BinaryTreePreorderTraversalSolution {
  List<Integer> res = new ArrayList<>();

  public List<Integer> preorderTraversal(TreeNode root) {
    preorder(root);
    return res;
  }

  void preorder(TreeNode root) {
    if (root == null)
      return;
    res.add(root.val);
    preorder(root.left);
    preorder(root.right);
  }
}
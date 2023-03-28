package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.TreeNode;

public class BinaryTreePostorderTraversal {
  public static void main(String[] args) {
    BinaryTreePostorderTraversalSolution s = new BinaryTreePostorderTraversalSolution();
    TreeNode head = new TreeNode("1,null,2,3");
    List<Integer> res = s.postorderTraversal(head);
    System.out.println(res);
  }
}

class BinaryTreePostorderTraversalSolution {
  List<Integer> res = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    postorder(root);
    return res;
  }

  void postorder(TreeNode root) {
    if (root == null)
      return;
    postorder(root.left);
    postorder(root.right);
    res.add(root.val);
  }
}
package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import ssicf.commons.TreeNode;

public class ValidateBinarySearchTree {
  public static void main(String[] args) {
    ValidateBinarySearchTreeSolution s = new ValidateBinarySearchTreeSolution();
    TreeNode root = new TreeNode("5,4,6,null,null,3,7");
    boolean result = s.isValidBST(root);
    System.out.println(result);
  }
}

class ValidateBinarySearchTreeSolution {
  List<Integer> res = new ArrayList<>();

  public boolean isValidBST(TreeNode root) {
    inorder(root);
    if (res.size() <= 1)
      return true;
    else {
      for (int i = 1; i < res.size(); i++) {
        if (res.get(i) <= res.get(i - 1))
          return false;
      }
      return true;
    }
  }

  void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    res.add(root.val);
    inorder(root.right);
  }
}
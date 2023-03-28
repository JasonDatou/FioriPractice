package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Deque;
import ssicf.commons.TreeNode;

public class SuccessorLCCI {
  public static void main(String[] args) {
    TreeNode leftleftleft = new TreeNode(1);
    TreeNode leftleft = new TreeNode(2, leftleftleft, null);
    TreeNode leftright = new TreeNode(4);
    TreeNode left = new TreeNode(3, leftleft, leftright);
    TreeNode right = new TreeNode(6);
    TreeNode head = new TreeNode(5, left, right);

//    TreeNode right = new TreeNode(3);
//    TreeNode head = new TreeNode(2, null, right);

//    TreeNode leftrightleft = new TreeNode(3);
//    TreeNode leftrightright = new TreeNode(5);
//    TreeNode leftleft = new TreeNode(0);
//    TreeNode leftright = new TreeNode(4, leftrightleft, leftrightright);
//    TreeNode left = new TreeNode(2, leftleft, leftright);
//
//    TreeNode rightleft = new TreeNode(7);
//    TreeNode rightright = new TreeNode(9);
//    TreeNode right = new TreeNode(8, rightleft, rightright);
//
//    TreeNode head = new TreeNode(6, left, right);

    SuccessorLCCISolution s = new SuccessorLCCISolution();
    TreeNode result = s.inorderSuccessor(head, right);
    if (result == null)
      System.out.println("null");
    else
      System.out.println(result.val);
  }
}

class SuccessorLCCISolution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode prev = null, curr = root;
    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      if (prev == p) {
        return curr;
      }
      prev = curr;
      curr = curr.right;
    }
    return null;
  }
}


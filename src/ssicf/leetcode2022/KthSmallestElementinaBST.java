package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import ssicf.commons.TreeNode;

public class KthSmallestElementinaBST {
  public static void main(String[] args) {
    TreeNode a = new TreeNode(2);
    TreeNode b = new TreeNode(1, null, a);
    TreeNode c = new TreeNode(4);
    TreeNode head = new TreeNode(3, b, c);

    KthSmallestElementinaBSTSolution s = new KthSmallestElementinaBSTSolution();
    int result = s.kthSmallest(head, 4);
    System.out.println(result);
  }
}

class KthSmallestElementinaBSTSolution {
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new LinkedList<>();
    while (true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      k--;
      if (k == 0)
        break;
      root = root.right;
    }
    return root.val;
  }
}



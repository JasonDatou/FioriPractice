package ssicf.Leetcode2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import ssicf.commons.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversalIISolution s = new BinaryTreeLevelOrderTraversalIISolution();
    TreeNode head = new TreeNode("3,9,20,null,null,15,7");
    List<List<Integer>> result = s.levelOrderBottom(head);
    System.out.println(result);
  }
}

class BinaryTreeLevelOrderTraversalIISolution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null)
      return Collections.emptyList();
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int count = 0;
    while (!queue.isEmpty()) {
      count++;
      List<Integer> level = new ArrayList<>();
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode temp = queue.poll();
        level.add(temp.val);
        if (temp.left != null)
          queue.add(temp.left);
        if (temp.right != null)
          queue.add(temp.right);
      }
      res.add(level);
    }
    Collections.reverse(res);
    return res;
  }
}
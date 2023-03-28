package ssicf.Leetcode2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import ssicf.commons.TreeNode;

public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversalSolution s = new BinaryTreeLevelOrderTraversalSolution();
    TreeNode head = new TreeNode("3,9,20,null,null,15,7");
    List<List<Integer>> result = s.levelOrder(head);
    System.out.println(result);
  }
}

class BinaryTreeLevelOrderTraversalSolution {

  public List<List<Integer>> levelOrder(TreeNode root) {
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
      if (count % 2 == 0)
        Collections.reverse(level);
      res.add(level);
    }
    return res;
  }
}
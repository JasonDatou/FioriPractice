package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ssicf.commons.TreeNode;

public class LevelOrder {
  public static void main(String[] args) {
    LevelOrderSolution s = new LevelOrderSolution();
    TreeNode root = new TreeNode(0);
    int[] result = s.levelOrder(root);
    System.out.println(Arrays.toString(result));
  }
}

class LevelOrderSolution {
  List<Integer> res = new ArrayList<>();

  public int[] levelOrder(TreeNode root) {
    if (root == null)
      return new int[0];
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    level(list);
    return res.stream().mapToInt(i -> i).toArray();
  }

  private void level(List<TreeNode> list) {
    if (list.isEmpty())
      return;
    List<TreeNode> nextlist = new ArrayList<>();
    list.forEach(o -> {
      res.add(o.val);
      if (o.left != null)
        nextlist.add(o.left);
      if (o.right != null)
        nextlist.add(o.right);
    });
    level(nextlist);
  }
}

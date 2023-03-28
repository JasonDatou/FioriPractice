package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ssicf.commons.TreeNode;

public class LevelOrderII {
  public static void main(String[] args) {
    LevelOrderIISolution s = new LevelOrderIISolution();
    TreeNode root = new TreeNode("3, 9, 20, null, null, 15, 7");
    List<List<Integer>> result = s.levelOrder(root);
    System.out.println(result);
  }
}

class LevelOrderIISolution {
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null)
      return res;
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    level(list);
    return res;
  }

  private void level(List<TreeNode> list) {
    if (list.isEmpty())
      return;
    else {
      res.add(list.stream().map(o -> o.val).collect(Collectors.toList()));
    }
    List<TreeNode> nextlist = new ArrayList<>();
    list.forEach(o -> {
      if (o.left != null)
        nextlist.add(o.left);
      if (o.right != null)
        nextlist.add(o.right);
    });
    level(nextlist);
  }
}


package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import ssicf.commons.TreeNode;

public class LevelOrderIII {
  public static void main(String[] args) {
    LevelOrderIIISolution s = new LevelOrderIIISolution();
    TreeNode root = new TreeNode("1, 2, 3, 4, null, null, 5");
    List<List<Integer>> result = s.levelOrder(root);
    System.out.println(result);
  }
}

class LevelOrderIIISolution {
  List<List<Integer>> res = new ArrayList<>();
  boolean reverse = false;

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null)
      return res;
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    level(list, reverse);
    return res;
  }

  private void level(List<TreeNode> list, boolean reverse) {
    if (list.isEmpty())
      return;
    else {
      List<Integer> temp = list.stream().map(o -> o.val).collect(Collectors.toList());
      if (reverse)
        Collections.reverse(temp);
      res.add(temp);
    }
    List<TreeNode> nextlist = new ArrayList<>();
    list.forEach(o -> {
      if (o.left != null)
        nextlist.add(o.left);
      if (o.right != null)
        nextlist.add(o.right);
    });
    level(nextlist, !reverse);
  }
}


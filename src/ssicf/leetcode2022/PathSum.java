package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ssicf.commons.TreeNode;

public class PathSum {
  public static void main(String[] args) {
    PathSumSolution s = new PathSumSolution();
    TreeNode root = new TreeNode("1, 2, 3");
    List<List<Integer>> result = s.pathSum(root, 22);
    System.out.println(result);
  }
}

class PathSumSolution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int target) {
    sum(root, target);
    return res;
  }

  private void sum(TreeNode root, int target) {
    temp.add(root.val);
    if (root.left == null && root.right == null) {
      if (sum(temp) == target) {
        res.add(new ArrayList<>(temp));
      }
      temp.remove(temp.size() - 1);
      return;
    }
    if (root.left != null) {
      sum(root.left, target);
    }
    if (root.right != null) {
      sum(root.right, target);
    }
    temp.remove(temp.size() - 1);
  }

  private int sum(List<Integer> temp) {
    return temp.stream().mapToInt(o -> o).sum();
  }
}

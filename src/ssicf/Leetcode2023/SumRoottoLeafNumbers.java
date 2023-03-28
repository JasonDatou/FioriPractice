package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ssicf.commons.TreeNode;

public class SumRoottoLeafNumbers {
  public static void main(String[] args) {
    SumRoottoLeafNumbersSolution s = new SumRoottoLeafNumbersSolution();
    TreeNode root = new TreeNode("4,9,0,5,1");
    int result = s.sumNumbers(root);
    System.out.println(result);
  }
}

class SumRoottoLeafNumbersSolution {
  List<Integer> res = new ArrayList<>();

  public int sumNumbers(TreeNode root) {
    int sum = 0;
    dfs(root, 0, 0);
    for (Integer num : res) {
      sum += num;
    }
    return sum;
  }

  void dfs(TreeNode root, int depth, int lastres) {
    if (root == null) {
      return;
    }
    int temp = lastres * 10 + root.val;
    if (root.left == null && root.right == null) {
      res.add(temp);
    } else if (root.left == null) {
      dfs(root.right, depth + 1, temp);
    } else if (root.right == null) {
      dfs(root.left, depth + 1, temp);
    } else {
      dfs(root.left, depth + 1, temp);
      dfs(root.right, depth + 1, temp);
    }
  }
}
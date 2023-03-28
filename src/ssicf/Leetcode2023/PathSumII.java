package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.TreeNode;

public class PathSumII {
  public static void main(String[] args) {
    PathSumIISolution s = new PathSumIISolution();
    TreeNode root = new TreeNode("5,4,8,11,null,13,4,7,2,null,null,5,1");
//    TreeNode root = new TreeNode("1");
    List<List<Integer>> result = s.pathSum(root, 22);
    System.out.println(result);
  }
}

class PathSumIISolution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    calPathSum(root, targetSum);
    return res;
  }

  public void calPathSum(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    temp.add(root.val);
    if (root.left == null && root.right == null) {
      if (sum == root.val) {
        res.add(new ArrayList<>(temp));
      }
      temp.remove(temp.size() - 1);
      return;
    }
    calPathSum(root.left, sum - root.val);
    calPathSum(root.right, sum - root.val);
    temp.remove(temp.size() - 1);
  }
}

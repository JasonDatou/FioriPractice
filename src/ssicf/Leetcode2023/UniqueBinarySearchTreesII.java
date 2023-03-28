package ssicf.Leetcode2023;

import java.util.LinkedList;
import java.util.List;
import ssicf.commons.TreeNode;

public class UniqueBinarySearchTreesII {
  public static void main(String[] args) {
    UniqueBinarySearchTreesIISolution s = new UniqueBinarySearchTreesIISolution();
    List<TreeNode> result = s.generateTrees(2);
    System.out.println(result);
  }
}

class UniqueBinarySearchTreesIISolution {
  public List<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int start, int end) {
    List<TreeNode> result = new LinkedList<>();
    if (start > end) {
      result.add(null);
      return result;
    }

    for (int i = start; i <= end; i++) {  // 1 -> n.
      List<TreeNode> leftTrees = generateTrees(start, i - 1);
      List<TreeNode> rightTrees = generateTrees(i + 1, end);

      // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
      for (TreeNode left : leftTrees) {
        for (TreeNode right : rightTrees) {
          TreeNode currTree = new TreeNode(i);
          currTree.left = left;
          currTree.right = right;
          result.add(currTree);
        }
      }
    }
    return result;
  }

}
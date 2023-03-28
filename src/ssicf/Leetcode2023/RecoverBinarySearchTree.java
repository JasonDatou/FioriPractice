package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import ssicf.commons.TreeNode;

public class RecoverBinarySearchTree {
  public static void main(String[] args) {
    RecoverBinarySearchTreeSolution s = new RecoverBinarySearchTreeSolution();
    TreeNode root = new TreeNode("1,3,null,null,2");
    s.recoverTree(root);
    System.out.println(root);
  }
}

class RecoverBinarySearchTreeSolution {
  List<TreeNode> res = new ArrayList<>();

  public void recoverTree(TreeNode root) {
    int first = -1;
    int second = -1;

    inorder(root);
    List<TreeNode> sortedres = new ArrayList<>(res);
    sortedres.sort(Comparator.comparingInt(a -> a.val));
    for (int i = 0; i < res.size(); i++) {
      if (res.get(i).val != sortedres.get(i).val) {
        if (first == -1) {
          first = i;
          continue;
        }
        if (second == -1) {
          second = i;
          break;
        }
      }
    }
    swap(res.get(first), res.get(second));
  }

  private void inorder(TreeNode root) {
    if (root == null)
      return;
    inorder(root.left);
    res.add(root);
    inorder(root.right);
  }

  private void swap(TreeNode a, TreeNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
  }
}

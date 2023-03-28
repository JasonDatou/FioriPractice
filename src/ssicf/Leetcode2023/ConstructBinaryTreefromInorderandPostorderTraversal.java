package ssicf.Leetcode2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import ssicf.commons.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
  public static void main(String[] args) {
    ConstructBinaryTreefromInorderandPostorderTraversalSolution s = new ConstructBinaryTreefromInorderandPostorderTraversalSolution();
    TreeNode result = s.buildTree(new int[]{2, 1}, new int[]{2, 1});
    System.out.println(result);
  }
}

class ConstructBinaryTreefromInorderandPostorderTraversalSolution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    if (inorder.length == 1)
      return root;
    int rootIndex = -1;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == root.val) {
        rootIndex = i;
        break;
      }
    }
    if (rootIndex > 0)
      root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex),
          Arrays.copyOfRange(postorder, 0, rootIndex));
    if (inorder.length > rootIndex + 1)
      root.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length),
          Arrays.copyOfRange(postorder, rootIndex, inorder.length - 1));
    return root;
  }
}
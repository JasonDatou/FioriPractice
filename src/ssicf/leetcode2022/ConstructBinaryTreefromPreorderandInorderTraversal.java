package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public static void main(String[] args) {
    ConstructBinaryTreefromPreorderandInorderTraversalSolution s = new ConstructBinaryTreefromPreorderandInorderTraversalSolution();

    TreeNode result = s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    System.out.println(result);
  }
}

class ConstructBinaryTreefromPreorderandInorderTraversalSolution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  TreeNode build(int[] preorder, int[] inorder, int preFrom, int preTo, int inFrom, int inTo) {
    if (preFrom > preTo || inFrom > inTo)
      return null;
    TreeNode root = new TreeNode(preorder[preFrom]);
    int indexRoot = inFrom;
    for (int i = inFrom; i <= inTo; i++) {
      if (inorder[i] == preorder[preFrom]) {
        indexRoot = i; // 1
        break;
      }
    }
    root.left = build(preorder, inorder, preFrom + 1, preFrom + indexRoot - inFrom, inFrom, indexRoot - 1);
    root.right = build(preorder, inorder, preFrom + indexRoot - inFrom + 1, preTo, indexRoot + 1, inTo);
    return root;
  }
}

package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class IsSubStructure {
  public static void main(String[] args) {

    TreeNode a = new TreeNode(4);
    TreeNode b = new TreeNode(3, null, null);
    TreeNode c = new TreeNode(2, a, null);
    TreeNode d = new TreeNode(1, b, c);

    IsSubStructureSolution s = new IsSubStructureSolution();
    boolean result = s.isSubStructure(d, null);
    System.out.println(result);
  }
}

class IsSubStructureSolution {
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A == null || B == null)
      return false;
    if (isSub(A, B))
      return true;
    return isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }

  boolean isSub(TreeNode A, TreeNode B) {
    if (A == null && B == null)
      return true;
    if (A == null)
      return false;
    if (B == null)
      return true;
    return A.val == B.val && isSub(A.left, B.left) && isSub(A.right, B.right);
  }
}

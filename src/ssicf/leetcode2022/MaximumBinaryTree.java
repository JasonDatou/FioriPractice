package ssicf.leetcode2022;

import ssicf.commons.TreeNode;

public class MaximumBinaryTree {
  public static void main(String[] args) {
    MaximumBinaryTreeSolution s = new MaximumBinaryTreeSolution();
    int[] nums = new int[]{3, 2, 1, 6, 0, 5};
    TreeNode result = s.constructMaximumBinaryTree(nums);
    System.out.println(result);
  }
}

class MaximumBinaryTreeSolution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return construct(0, nums.length - 1, nums);
  }

  TreeNode construct(int start, int end, int[] nums) {
    if (start == end)
      return new TreeNode(nums[start]);
    int indexMax = findMax(start, end, nums);
    if (indexMax == start)
      return new TreeNode(nums[indexMax],
          null, construct(indexMax + 1, end, nums));
    else if (indexMax == end)
      return new TreeNode(nums[indexMax],
          construct(start, indexMax - 1, nums), null);
    else
      return new TreeNode(nums[indexMax],
          construct(start, indexMax - 1, nums),
          construct(indexMax + 1, end, nums));
  }

  int findMax(int start, int end, int[] nums) {
    int indexMax = start;
    for (int i = start + 1; i <= end; i++) {
      if (nums[i] > nums[indexMax]) {
        indexMax = i;
      }
    }
    return indexMax;
  }

}

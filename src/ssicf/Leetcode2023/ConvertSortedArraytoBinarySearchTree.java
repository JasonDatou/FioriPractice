package ssicf.Leetcode2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import ssicf.commons.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
  public static void main(String[] args) {
    ConvertSortedArraytoBinarySearchTreeSolution s = new ConvertSortedArraytoBinarySearchTreeSolution();
    TreeNode result = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    System.out.println(result);
  }
}

class ConvertSortedArraytoBinarySearchTreeSolution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0)
      return null;
    int mid = (nums.length + 1) / 2 - 1;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
    root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
    return root;
  }
}
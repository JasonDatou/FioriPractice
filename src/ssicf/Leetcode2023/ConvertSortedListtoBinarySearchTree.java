package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ssicf.commons.ListNode;
import ssicf.commons.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
  public static void main(String[] args) {
    ConvertSortedListtoBinarySearchTreeSolution s = new ConvertSortedListtoBinarySearchTreeSolution();
    ListNode root = new ListNode(new int[]{-10, -3, 0, 5, 9});
    TreeNode result = s.sortedListToBST(root);
    System.out.println(result);
  }
}

class ConvertSortedListtoBinarySearchTreeSolution {
  public TreeNode sortedListToBST(ListNode head) {
    return sortedArrayToBST(convertNodesToList(head));
  }

  List<Integer> convertNodesToList(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    return list;
  }

  TreeNode sortedArrayToBST(List<Integer> nums) {
    if (nums.size() == 0)
      return null;
    int mid = (nums.size() + 1) / 2 - 1;
    TreeNode root = new TreeNode(nums.get(mid));
    root.left = sortedArrayToBST(nums.subList(0, mid));
    root.right = sortedArrayToBST(nums.subList(mid + 1, nums.size()));
    return root;
  }
}
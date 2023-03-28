package ssicf.leetcode2022;

public class VerifyPostorder {
  public static void main(String[] args) {
    VerifyPostorderSolution s = new VerifyPostorderSolution();
    int[] nums = new int[]{ 5, 10, 6, 9, 4};
    boolean result = s.verifyPostorder(nums);
    System.out.println(result);
  }
}

class VerifyPostorderSolution {
  public boolean verifyPostorder(int[] postorder) {
    return helper(postorder, 0, postorder.length - 1);
  }

  boolean helper(int[] postorder, int left, int right) {
    if (left >= right)
      return true;
    // find mid
    int root = postorder[right];
    int mid = left;
    while (postorder[mid] < root)
      mid++;

    for (int i = mid; i < right; i++) {
      if (postorder[i] < root)
        return false;
    }
    return helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
  }
}

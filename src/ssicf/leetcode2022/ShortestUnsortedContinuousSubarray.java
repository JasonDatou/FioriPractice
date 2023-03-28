package ssicf.leetcode2022;

public class ShortestUnsortedContinuousSubarray {
  public static void main(String[] args) {
    ShortestUnsortedContinuousSubarraySolution s = new ShortestUnsortedContinuousSubarraySolution();
    int[] nums = new int[]{1, 2, 3, 4};
    int result = s.findUnsortedSubarray(nums);
    System.out.println(result);
  }
}

class ShortestUnsortedContinuousSubarraySolution {
  public int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int left = n, min = Integer.MAX_VALUE;
    int right = -1, max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (nums[i] < max)
        right = i;
      else
        max = nums[i];

      if (nums[n - i - 1] > min)
        left = n - i - 1;
      else
        min = nums[n - i - 1];

    }
    if (left == n)
      return 0;
    return right - left + 1;
  }
}

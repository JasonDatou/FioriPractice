package ssicf.leetcode2022;

public class MaximumSubarray {
  public static void main(String[] args) {
    MaximumSubarraySolution s = new MaximumSubarraySolution();
    int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result = s.maxSubArray(nums);
    System.out.println(result);
  }
}

class MaximumSubarraySolution {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int pre = nums[0];
    for (int i = 1; i < nums.length; i++) {
//      pre = Math.max(pre + nums[i], nums[i]);
//      max = Math.max(max, pre);

      int currMax = Math.max(pre + nums[i], nums[i]);
      max = Math.max(max, currMax);
      pre = currMax;
    }
    return max;
  }

}

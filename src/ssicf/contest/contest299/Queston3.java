package ssicf.contest.contest299;


import java.util.Arrays;

class Queston3 {
  public static void main(String[] args) {
    Queston3Solution s = new Queston3Solution();
    int[] num1 = new int[]{60, 60, 60};
    int[] num2 = new int[]{10, 90, 10};
//                         -50， 30， -50，
    int result = s.maximumsSplicedArray(num1, num2);
    System.out.println(result);
  }
}

class Queston3Solution {
  public int maximumsSplicedArray(int[] nums1, int[] nums2) {
    return Math.max(solve(nums1, nums2), solve(nums2, nums1));
  }

  int solve(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int[] chazhi = new int[n];
    for (int i = 0; i < n; i++) {
      chazhi[i] = nums2[i] - nums1[i];
    }
    return Arrays.stream(nums1).sum() + maxSubArray(chazhi);
  }

  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int pre = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currMax = Math.max(pre + nums[i], nums[i]);
      max = Math.max(max, currMax);
      pre = currMax;
    }
    return max;
  }

}


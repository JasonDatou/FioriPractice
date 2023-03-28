package ssicf.leetcode2022;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArraySolution s = new MaxSubArraySolution();
        int[] nums = new int[]{1};
        int result = s.maxSubArray(nums);
        System.out.println(result);
    }
}

class MaxSubArraySolution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = Math.max(nums[i], res[i - 1] + nums[i]);
            result = Math.max(res[i], result);
        }
        return result;
    }
}

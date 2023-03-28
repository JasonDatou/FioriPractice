package ssicf.leetcode2022;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
  public static void main(String[] args) {
    MinimumMovestoEqualArrayElementsIISolution s = new MinimumMovestoEqualArrayElementsIISolution();
    int[] nums = new int[]{1, 2, 3};
    int result = s.minMoves2(nums);
    System.out.println(result);
  }
}

class MinimumMovestoEqualArrayElementsIISolution {
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int res = 0;
    int mid = nums[nums.length / 2];
    for (int num : nums) {
      res += Math.abs(num - mid);
    }
    return res;
  }
}

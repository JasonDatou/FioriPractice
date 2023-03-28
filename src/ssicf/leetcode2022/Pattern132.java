package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern132 {
  public static void main(String[] args) {
    Pattern132Solution s = new Pattern132Solution();
    int[] nums = new int[]{1, -4, 2, -1, 3, -3, -4, 0, -3, -1};
    boolean result = s.find132pattern(nums);
    System.out.println(result);
  }
}

class Pattern132Solution {
  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    int[] minLeft = new int[n];
    minLeft[0] = nums[0];
    for (int i = 1; i < n - 1; i++) {
      minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
    }
    Deque<Integer> monostack = new ArrayDeque<>();
    for (int i = n - 1; i > 0; i--) {
      if (minLeft[i - 1] < nums[i]) {
        while (!monostack.isEmpty() && monostack.peek() <= minLeft[i - 1])
          monostack.pop();
        if (!monostack.isEmpty() && nums[i] > monostack.peek())
          return true;
        monostack.push(nums[i]);
      }
    }
    return false;
  }
}

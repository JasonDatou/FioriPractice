package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
  public static void main(String[] args) {
    NextGreaterElementIISolution s = new NextGreaterElementIISolution();
    int[] nums1 = new int[]{1, 2, 3, 4, 3};
    int[] result = s.nextGreaterElements(nums1);
    System.out.println(Arrays.toString(result));
  }
}

class NextGreaterElementIISolution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Deque<Integer> monostack = new ArrayDeque<>();
    int times = 2;
    while (times-- > 0) {
      for (int i = 0; i < n; i++) {
        while (!monostack.isEmpty() && nums[monostack.peek()] < nums[i]) {
          res[monostack.pop()] = nums[i];
        }
        monostack.push(i);
      }
    }
    return res;
  }
}

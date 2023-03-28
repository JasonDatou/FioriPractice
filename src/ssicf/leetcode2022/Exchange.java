package ssicf.leetcode2022;

import java.util.Arrays;

public class Exchange {
  public static void main(String[] args) {
    ExchangeSolution s = new ExchangeSolution();
    int[] nums = new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
    int[] result = s.exchange(nums);
    System.out.println(Arrays.toString(result));
  }
}

class ExchangeSolution {
  public int[] exchange(int[] nums) {
    int left = 0;
    int righit = nums.length - 1;
    while (left < righit) {
      if (nums[left] % 2 == 0) {
        while (nums[righit] % 2 == 0 && left < righit) {
          righit--;
        }
        swap(nums, left, righit);
      }
      left++;
    }
    return nums;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

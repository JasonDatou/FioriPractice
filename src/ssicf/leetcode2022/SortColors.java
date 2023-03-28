package ssicf.leetcode2022;

import java.util.Arrays;

public class SortColors {
  public static void main(String[] args) {
    SortColorsSolution s = new SortColorsSolution();
    int[] nums = new int[]{0, 1};
    s.sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}

class SortColorsSolution {
  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (i != zeroIndex) {
          int temp = nums[i];
          nums[i] = nums[zeroIndex];
          nums[zeroIndex] = temp;
        }
        zeroIndex++;
      }
    }

    int oneIndex = zeroIndex;
    for (int i = oneIndex; i < nums.length; i++) {
      if (nums[i] == 1) {
        if (i != oneIndex) {
          int temp = nums[i];
          nums[i] = nums[oneIndex];
          nums[oneIndex] = temp;
        }
        oneIndex++;
      }
    }
  }
}

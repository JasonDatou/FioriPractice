package ssicf.leetcode2022;

import java.util.Arrays;

public class NextPermutation {
  public static void main(String[] args){
    int []input = new int[]{1,3,2};
    NextPermutationSolution s = new NextPermutationSolution();
    s.nextPermutation(input);
    System.out.println(Arrays.toString(input));
  }
}

class NextPermutationSolution {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void reverse(int[] nums, int start) {
    int left = start, right = nums.length - 1;
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }
}



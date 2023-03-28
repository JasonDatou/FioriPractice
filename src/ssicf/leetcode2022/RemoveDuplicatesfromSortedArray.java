package ssicf.leetcode2022;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
  public static void main(String[] args){
    int[] nums = {1,2,2,3};
    RemoveDuplicatesfromSortedArraySolution s = new RemoveDuplicatesfromSortedArraySolution();
    int result = s.removeDuplicates(nums);
    System.out.println(result);
  }
}

class RemoveDuplicatesfromSortedArraySolution {
  public int removeDuplicates(int[] nums) {
    int result = 0;
    for(int i=0; i<nums.length; i++){
      if(i == 0 || nums[i] != nums[i-1]){
        result += 1;
        if(i != result-1){
          nums[result-1] = nums[i];
        }
      }
    }
    System.out.println(Arrays.toString(nums));
    return result;
  }
}

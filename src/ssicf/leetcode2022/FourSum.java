package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static void main(String[] args){
    FourSumSolution s = new FourSumSolution();
    int []nums = new int[]{2,2,2,2,2};
    List<List<Integer>> result = s.threeSum(nums,8);
    System.out.println(result.toString());
  }
}

class FourSumSolution {
  public List<List<Integer>> threeSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0; i<nums.length; i++){
      for(int j=i+1; j<nums.length; j++){
        int L = j+1;
        int R = nums.length-1;
        while(L<R){
          int sum = nums[i] + nums[j] + nums[R] + nums[L] - target;
          if(sum == 0){
            if(!result.contains(Arrays.asList(nums[i], nums[j], nums[R], nums[L])))
              result.add(Arrays.asList(nums[i], nums[j], nums[R], nums[L]));
            L++;
          }else if(sum < 0){
            L++;
          }else {
            R--;
          }
        }
      }
    }
    return result;
  }
}


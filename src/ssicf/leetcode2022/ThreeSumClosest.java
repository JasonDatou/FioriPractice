package ssicf.leetcode2022;

import java.util.Arrays;

public class ThreeSumClosest {
  public static void main(String[] args){
    ThreeSumClosestSolution s = new ThreeSumClosestSolution();
    int []nums = new int[]{0,2,1,-3};
    int result = s.threeSumClosest(nums, 1);
    System.out.println(result);
  }
}

class ThreeSumClosestSolution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int result = target;
    int gap=Integer.MAX_VALUE;
    for(int i=0; i<nums.length; i++){
      int L = i+1;
      int R = nums.length-1;
      while (L<R){
        int tempResult = nums[i] + nums[L] + nums[R];
        int gapWithDir = target - tempResult;
        if(Math.abs(gapWithDir) < gap){
          gap = Math.abs(gapWithDir);
          result=tempResult;
        }
        if(gapWithDir==0) return target;
        if(gapWithDir>0) L++;
        if(gapWithDir<0) R--;
      }
    }
    return result;
  }
}

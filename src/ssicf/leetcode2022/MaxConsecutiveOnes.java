package ssicf.leetcode2022;

public class MaxConsecutiveOnes {
  public static void main(String[] args){
    MaxConsecutiveOnesSolution s = new MaxConsecutiveOnesSolution();
    int []nums = new int[]{1,1,0,1,1,1};
    int result = s.findMaxConsecutiveOnes(nums);
    System.out.println(result);
  }
}

class MaxConsecutiveOnesSolution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int max = 0;
    for(int num: nums){
      if(num == 1){
        count += 1;
      }else {
        count = 0;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}

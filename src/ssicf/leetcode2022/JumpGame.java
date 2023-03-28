package ssicf.leetcode2022;

public class JumpGame {
  public static void main(String[] args){
    JumpGameSolution s = new JumpGameSolution();
    int []nums = new int[]{0};
    boolean result = s.canJump(nums);
    System.out.println(result);
  }
}

class JumpGameSolution {
  public boolean canJump(int[] nums) {
    int currLength = 0;
    for(int i=0; i<nums.length; i++){
      currLength = Math.max(currLength, i+nums[i]);
      if(i == currLength && i != nums.length-1){
        return false;
      }
    }
    return true;
  }
}

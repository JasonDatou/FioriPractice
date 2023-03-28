package ssicf.leetcode2022;

public class RemoveElement {
  public static void main(String[] args){
    int[] nums = {0,1,2,2,3,0,4,2};
    RemoveElementSolution s = new RemoveElementSolution();
    int result = s.removeElement(nums,2);
    System.out.println(result);
  }
}

class RemoveElementSolution {
  public int removeElement(int[] nums, int val) {
    int result = 0;
    for(int i=0; i<nums.length; i++){
      if(result > 0) {
        nums[i - result] = nums[i];
      }
      if(nums[i] == val){
        result += 1;
      }
    }
    return nums.length - result;
  }
}

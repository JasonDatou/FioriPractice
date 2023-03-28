package ssicf.leetcode2022;

public class MaxConsecutiveOnesIII {
  public static void main(String[] args) {
    MaxConsecutiveOnesIIISolution s = new MaxConsecutiveOnesIIISolution();
    int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
    int result = s.longestOnes(nums, 2);
    System.out.println(result);
  }
}

class MaxConsecutiveOnesIIISolution {
  public int longestOnes(int[] nums, int k) {
    int left = 0;
    int right = 0;
    int zeros = 0;
    int result = 0;
    while (right < nums.length){
      if(nums[right] == 0){
        zeros++;
      }
      while (zeros > k){
        if(nums[left++] == 0) {
          zeros--;
        }
      }
      result = Math.max(right - left + 1, result);
      right++;
      if(left >= nums.length - result)
        break;
    }
    return result;
  }
}

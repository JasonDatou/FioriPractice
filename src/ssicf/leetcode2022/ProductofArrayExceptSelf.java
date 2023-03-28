package ssicf.leetcode2022;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
  public static void main(String[] args) {
    ProductofArrayExceptSelfSolution s = new ProductofArrayExceptSelfSolution();
    int[] nums = new int[]{1, 2, 3, 4};
    int[] result = s.productExceptSelf(nums);
    System.out.println(Arrays.toString(result));
  }
}

class ProductofArrayExceptSelfSolution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    for (int i = n-1; i >=0; i--) {
      res[i] = i == n-1 ? 1 : nums[i+1] * res[i + 1];
    }
    int left = 1;
    for(int i=0; i<n; i++){
      if(i>0)
        left = left * nums[i-1];
      res[i] = left * res[i];
    }
    return res;
  }
}

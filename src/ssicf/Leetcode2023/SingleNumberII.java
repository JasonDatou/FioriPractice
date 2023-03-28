package ssicf.Leetcode2023;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumberII {
  public static void main(String[] args) {
    SingleNumberIISolution s = new SingleNumberIISolution();
    int[] nums = new int[]{2, 2, 1};
    int result = s.singleNumber(nums);
    System.out.println(result);
  }
}

class SingleNumberIISolution {
  public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;
    for(int num : nums){
      ones = ones ^ num & ~twos;
      twos = twos ^ num & ~ones;
    }
    return ones;
  }
}
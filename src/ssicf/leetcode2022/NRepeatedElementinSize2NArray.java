package ssicf.leetcode2022;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray {
  public static void main(String[] args) {
    NRepeatedElementinSize2NArraySolution s = new NRepeatedElementinSize2NArraySolution();
    int[] nums = new int[]{1, 2, 3, 3};
    int result = s.repeatedNTimes(nums);
    System.out.println(result);
  }
}

class NRepeatedElementinSize2NArraySolution {
  public int repeatedNTimes(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      if (numSet.contains(num))
        return num;
      numSet.add(num);
    }
    return 0;
  }
}

package ssicf.leetcode2022;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
  public static void main(String[] args) {
    FirstMissingPositiveSolution s = new FirstMissingPositiveSolution();
    int[] nums = new int[]{2, 4, -1, 1};
    int result = s.firstMissingPositive(nums);
    System.out.println(result);
  }
}


class FirstMissingPositiveSolution {
  public int firstMissingPositive(int[] nums) {
    int result = 1;
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      if (num > 0)
        numSet.add(num);
    }
    while (numSet.contains(result)) {
      result += 1;
    }
    return result;
  }
}

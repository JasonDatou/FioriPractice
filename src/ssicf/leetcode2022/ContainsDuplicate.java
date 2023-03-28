package ssicf.leetcode2022;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public static void main(String[] args) {
    ContainsDuplicateSolution s = new ContainsDuplicateSolution();
    int[] nums = new int[]{3, 3};
    boolean result = s.containsDuplicate(nums);
    System.out.println(result);
  }
}

class ContainsDuplicateSolution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> numSet = new HashSet<>(nums.length);
    for (int num : nums) {
      if (numSet.contains(num)) {
        return true;
      } else
        numSet.add(num);
    }
    return false;
  }
}

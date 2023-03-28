package ssicf.leetcode2022;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber  {
  public static void main(String[] args){
    SingleNumberSolution s = new SingleNumberSolution();
    int []nums = new int[]{2,2,1};
    int result = s.singleNumber(nums);
    System.out.println(result);
  }
}

class SingleNumberSolution {
  public int singleNumber(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      if (numSet.contains(num))
        numSet.remove(num);
      else
        numSet.add(num);
    }
    return (int)numSet.toArray()[0];
  }
}

package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
  public static void main(String[] args) {
    FindAllDuplicatesinanArraySolution s = new FindAllDuplicatesinanArraySolution();
    int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> result = s.findDuplicates(nums);
    System.out.println(result);
  }
}

class FindAllDuplicatesinanArraySolution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int[] record = new int[nums.length];
    for (int num : nums) {
      if (record[num - 1] == 1)
        result.add(num);
      else
        record[num - 1] = 1;
    }
    return result;
  }
}

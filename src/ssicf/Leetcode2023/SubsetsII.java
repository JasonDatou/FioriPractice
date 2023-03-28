package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubsetsII {
  public static void main(String[] args) {
    SubsetsIISolution s = new SubsetsIISolution();
    List<List<Integer>> result = s.subsetsWithDup(new int[]{1, 2});
    System.out.println(result);
  }
}

class SubsetsIISolution {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backtrak(nums, 0);
    return result;
  }

  void backtrak(int[] nums, int startIndex) {
    result.add(new ArrayList<>(temp));
    for (int i = startIndex; i < nums.length; i++) {
      if (i > startIndex && nums[i] == nums[i - 1])
        continue;
      temp.add(nums[i]);
      backtrak(nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}

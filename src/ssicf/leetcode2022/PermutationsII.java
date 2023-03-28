package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
  public static void main(String[] args) {
    PermutationsIISolution s = new PermutationsIISolution();
    int[] nums = new int[]{1, 1, 2}; // 2 0 1 0
    List<List<Integer>> result = s.permuteUnique(nums);
    System.out.println(result);
  }
}

class PermutationsIISolution {
  List<Integer> usedList = new ArrayList<>();
  List<List<Integer>> result = new ArrayList<>();
  int targetLength = 0;

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    targetLength = nums.length;
    boolean []vis = new boolean[nums.length];
    backtrack(0, nums, vis);
    return result;
  }

  void backtrack(int depth, int[] nums, boolean []vis) {
    if (usedList.size() == this.targetLength) {
      result.add(new ArrayList<>(usedList));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if(vis[i])
        continue;
      if (i > 0 && nums[i] == nums[i - 1] && !vis[i-1])
        continue;
      usedList.add(nums[i]);
      vis[i] = true;
//      swap(nums, i, startIndex);
      backtrack(depth + 1, nums, vis);
//      swap(nums, i, startIndex);
      vis[i] = false;
      usedList.remove(usedList.size() - 1);
    }
  }

  void swap(int[] nums, int i, int j) {
    if (i == j)
      return;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

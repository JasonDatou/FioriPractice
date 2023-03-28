package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  public static void main(String[] args) {
    SubsetsSolution s = new SubsetsSolution();
    int[] nums = new int[]{1, 2, 3};
    List<List<Integer>> result = s.subsets(nums);
    System.out.println(result);
  }
}

class SubsetsSolution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> currSet = new ArrayList<>();
    List<Integer> unusedNums = new ArrayList<>();
    res.add(new ArrayList<>());
    for (int num : nums)
      unusedNums.add(num);
    backTrack(res, 0, currSet, unusedNums);
    return res;
  }

  void backTrack(List<List<Integer>> res, int index, List<Integer> currSet, List<Integer> unusedNums) {
    if (unusedNums.isEmpty()) {
      return;
    }
    for (int i = index; i < unusedNums.size(); i++) {
      currSet.add(unusedNums.get(i));
      res.add(new ArrayList<>(currSet));
      List<Integer> unusedNumsNext = new ArrayList<>(unusedNums);
      unusedNumsNext.remove(i);
      backTrack(res, i, currSet, unusedNumsNext);
      currSet.remove(currSet.size() - 1);
    }
  }
}

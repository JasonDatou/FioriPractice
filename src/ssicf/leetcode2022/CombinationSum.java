package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  public static void main(String[] args) {
    CombinationSumSolution s = new CombinationSumSolution();
    int[] nums = new int[]{2, 3, 6, 7};
    List<List<Integer>> result = s.combinationSum(nums, 7);
    System.out.println(result);
  }
}

class CombinationSumSolution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> usedList = new ArrayList<>();
    backTrack(result, usedList, candidates, target, 0);
    return result;
  }

  private void backTrack(List<List<Integer>> result, List<Integer> usedList, int[] candidates, int target, int fromIndex) {
    if (target == 0) {
      result.add(new ArrayList<>(usedList));
      usedList.remove(usedList.size() - 1);
      return;
    }
    if (target < 0) {
      usedList.remove(usedList.size() - 1);
      return;
    }
    for (int i = fromIndex; i < candidates.length; i++) {
      usedList.add(candidates[i]);
      backTrack(result, usedList, candidates, target - candidates[i], i);
    }
    if (!usedList.isEmpty())
      usedList.remove(usedList.size() - 1);
  }
}

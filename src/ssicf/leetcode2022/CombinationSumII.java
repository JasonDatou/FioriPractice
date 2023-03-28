package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  public static void main(String[] args) {
    CombinationSumIISolution s = new CombinationSumIISolution();
    int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
    List<List<Integer>> result = s.combinationSum2(nums, 8);
    System.out.println(result);
  }
}

class CombinationSumIISolution {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> usedList = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    backTrack(0, candidates, target);
    return new ArrayList<>(result);
  }

  void backTrack(int fromIndex, int[] unusedList, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(usedList));
    } else if (target > 0) {
      for (int i = fromIndex; i < unusedList.length; i++) {
        if (i > fromIndex && unusedList[i] == unusedList[i - 1])
          continue;
        if(target - unusedList[i] < 0)
          break;
        usedList.add(unusedList[i]);
        backTrack(i + 1, unusedList, target - unusedList[i]);
        usedList.remove((usedList.size() - 1));
      }
    }
  }
}

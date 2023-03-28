package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public static void main(String[] args) {
    PermutationsSolution s = new PermutationsSolution();
    int[] nums = new int[]{};
    List<List<Integer>> result = s.permute(nums);
    System.out.println(result);
  }
}

class PermutationsSolution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> usedList = new ArrayList<>();
    List<Integer> unusedList = new ArrayList<>();
    for(int num : nums){
      unusedList.add(num);
    }
    backtrack(nums.length, usedList, unusedList, result);
    return result;
  }

  void backtrack(int length, List<Integer> usedList, List<Integer> unusedList, List<List<Integer>> result) {
    if (usedList.size() == length) {
      result.add(new ArrayList<>(usedList));
      return;
    }
    for (int i = 0; i < unusedList.size(); i++) {
      int num = unusedList.get(i);
      usedList.add(num);
      List<Integer> unusedList2 = new ArrayList<>(unusedList);
      unusedList2.remove(i);
      backtrack(length, usedList, unusedList2, result);
      usedList.remove(usedList.size() - 1);
    }
  }
}

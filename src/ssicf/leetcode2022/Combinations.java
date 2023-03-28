package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  public static void main(String[] args) {
    CombinationsSolution s = new CombinationsSolution();
    List<List<Integer>> result = s.combine(4, 2);
    System.out.println(result);
  }
}

class CombinationsSolution {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> temp = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    backTrack(k, 0, n);
    return result;
  }

  void backTrack(int target, int fromIndex, int n) {
    if (temp.size() == target) {
      result.add(new ArrayList<>(temp));
    }
    for (int i = fromIndex; i < n; i++) {
      temp.add(i + 1);
      backTrack(target, i + 1, n);
      temp.remove(temp.size() - 1);
    }
  }
}

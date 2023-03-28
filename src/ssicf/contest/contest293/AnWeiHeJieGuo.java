package ssicf.contest.contest293;


import java.util.ArrayList;
import java.util.List;

class AnWeiHeJieGuo {
  public static void main(String[] args) {
    AnWeiHeJieGuoSolution s = new AnWeiHeJieGuoSolution();
    int[] nums = new int[]{39,79,15,70,18,8,67,34,71,80,90,22,27,41,95,15,42,70,43,92,77,13,44,71,79,33,46,62,20,81,94,56,79,53,29,71};
    int result = s.largestCombination(nums);
    System.out.println(result);
  }
}

class AnWeiHeJieGuoSolution {
  List<Integer> list = new ArrayList<>();
  int res = 0;

  public int largestCombination(int[] candidates) {
    backTrack(candidates, 0);
    return res;
  }

  void backTrack(int[] candidates, int startIndex) {
    if (andOp(list) > 0) {
      res = Math.max(res, list.size());
    } else {
      if (list.size() != 0 )
        return;
    }
    if (list.size() == candidates.length)
      return;
    for (int i = startIndex; i < candidates.length; i++) {
      list.add(candidates[i]);
      backTrack(candidates, i + 1);
      list.remove((Object) candidates[i]);
    }
  }

  int andOp(List<Integer> list) {
    if (list.isEmpty())
      return 0;
    int res = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      res &= list.get(i);
    }
    return res;
  }
}

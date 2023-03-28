package ssicf.contest.contest293;


import java.util.Arrays;

class BuHanTeShuCeng {
  public static void main(String[] args) {
    BuHanTeShuCengSolution s = new BuHanTeShuCengSolution();
    int[] special = new int[]{4,6};
    int result = s.maxConsecutive(2, 9, special);
    System.out.println(result);
  }
}

class BuHanTeShuCengSolution {
  public int maxConsecutive(int bottom, int top, int[] special) {
    int res = 0;
    int gap = 0;
    Arrays.sort(special);
    for (int value : special) {
      gap = value - bottom;
      res = Math.max(res, gap);
      bottom = value+1;
    }
    res = Math.max(res, top + 1 - bottom);
    return res;
  }
}

package ssicf.leetcode2022;

public class FindRepeatNumber {
  public static void main(String[] args) {
    FindRepeatNumberSolution s = new FindRepeatNumberSolution();
    int result = s.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    System.out.println(result);
  }
}

class FindRepeatNumberSolution {
  public int findRepeatNumber(int[] nums) {
    boolean[] exist = new boolean[nums.length];
    for (int num : nums) {
      if (exist[num])
        return num;
      else
        exist[num] = true;
    }
    return -1;
  }
}

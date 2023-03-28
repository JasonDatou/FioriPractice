package ssicf.contest.contest298;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Queston2 {
  public static void main(String[] args) {
    Queston2Solution s = new Queston2Solution();
    int result = s.minimumNumbers(3000, 1);
    System.out.println(result);
  }
}

class Queston2Solution {
  public int minimumNumbers(int num, int k) {
    if (num == 0) return 0; // num为0的情况单独讨论
    // num >= k的情况:至少需要一个
    for (int i = 1; i <= num; i++) {
      int t = num - i * k;
      if (t >= 0 && t % 10 == 0) return i;
    }
    return -1;
  }
}

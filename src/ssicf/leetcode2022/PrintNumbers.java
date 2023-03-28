package ssicf.leetcode2022;

import java.util.Arrays;

public class PrintNumbers {
  public static void main(String[] args) {
    PrintNumbersSolution s = new PrintNumbersSolution();
    int[] result = s.printNumbers(3);
    System.out.println(Arrays.toString(result));
  }
}

class PrintNumbersSolution {
  public int[] printNumbers(int n) {
    int num = (int) (Math.pow(10, n) - 1);
    int[] res = new int[num];
    for (int i = 0; i < num; i++) {
      res[i] = i + 1;
    }
    return res;
  }
}

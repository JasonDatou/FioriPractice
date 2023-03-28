package ssicf.leetcode2022;

public class MinArray {
  public static void main(String[] args) {
    MinArraySolution s = new MinArraySolution();
    int result = s.minArray(new int[]{3, 4, 5, 1, 2});
    System.out.println(result);
  }
}

class MinArraySolution {
  public int minArray(int[] numbers) {
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] < numbers[i - 1])
        return numbers[i];
    }
    return numbers[0];
  }
}

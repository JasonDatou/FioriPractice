package ssicf.leetcode2022;

import java.util.Arrays;

public class SpiralOrder {
  public static void main(String[] args) {
    SpiralOrderSolution s = new SpiralOrderSolution();
    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
    int[] result = s.spiralOrder(matrix);
    System.out.println(Arrays.toString(result));
  }
}

class SpiralOrderSolution {
  public int[] spiralOrder(int[][] matrix) {
    if (matrix.length == 0)
      return new int[0];

    int row = matrix.length;
    int column = matrix[0].length;
    int[] res = new int[row * column];

    int left = 0;
    int right = column - 1;
    int top = 0;
    int bottom = row - 1;
    int index = 0;

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        res[index++] = matrix[top][i];
      }
      top++;
      for (int i = top; i <= bottom; i++) {
        res[index++] = matrix[i][right];
      }
      right--;
      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          res[index++] = matrix[bottom][i];
        }
        bottom--;
      }
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          res[index++] = matrix[i][left];
        }
        left++;
      }
    }
    return res;
  }
}

package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
    SpiralMatrixSolution s = new SpiralMatrixSolution();
    int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    List<Integer> result = s.spiralOrder(nums);
    System.out.println(result);
  }
}
//1  2  3  4 [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//5  6  7  8
//9 10 11 12

class SpiralMatrixSolution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int column = matrix.length;
    int row = matrix[0].length;
    int left = 0;
    int right = row - 1;
    int top = 0;
    int bottom = column - 1;

    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      for (int i = top + 1; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      if (left < right && top < bottom) {
        for (int i = right - 1; i >= left; i--) {
          result.add(matrix[bottom][i]);
        }
        for (int i = bottom - 1; i >= top + 1; i--) {
          result.add(matrix[i][left]);
        }
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return result;
  }
}

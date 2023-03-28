package ssicf.leetcode2022;

import java.util.Arrays;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    SetMatrixZeroesSolution s = new SetMatrixZeroesSolution();
    int[][] matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
    s.setZeroes(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
}

class SetMatrixZeroesSolution {
  public void setZeroes(int[][] matrix) {
    boolean[] row = new boolean[matrix.length]; // 3
    boolean[] column = new boolean[matrix[0].length]; // 4
    for (int i = 0; i < row.length; i++) { //3
      for (int j = 0; j < column.length; j++) { // 4
        if (matrix[i][j] == 0) {
          row[i] = true;
          column[j] = true;
        }
      }
    }
    for (int i = 0; i < row.length; i++) {
      for (int j = 0; j < column.length; j++) {
        if (row[i] || column[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}

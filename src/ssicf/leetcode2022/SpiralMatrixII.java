package ssicf.leetcode2022;

import java.util.Arrays;

public class SpiralMatrixII {
  public static void main(String[] args){
    SpiralMatrixIISolution s = new SpiralMatrixIISolution();
    int[][] result = s.generateMatrix(4);
    System.out.println(Arrays.deepToString(result));
  }
}

class SpiralMatrixIISolution {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int left = 0;
    int right = n-1;
    int top = 0;
    int bottom = n-1;
    int count = 1;
    while (left <= right){
      for(int i=left; i<=right; i++){
        res[top][i] = count++;
      }
      for(int i=top+1; i<=bottom; i++){
        res[i][right] = count++;
      }
      for(int i=right-1; i>=left; i--){
        res[bottom][i] = count++;
      }
      for(int i=bottom-1; i>=top+1; i--){
        res[i][left] = count++;
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return res;
  }
}

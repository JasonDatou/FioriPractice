package ssicf.leetcode2022;

public class RotateImage {
  public static void main(String[] args) {
    RotateImageSolution s = new RotateImageSolution();
    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    s.rotate(matrix);
    for(int[] m : matrix){
      for(int n: m){
        System.out.print(n);
      }
      System.out.println();
    }
  }
}

class RotateImageSolution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-j-1][n-i-1];
        matrix[n-j-1][n-i-1] = temp;
      }
    }
    for(int i=0; i<n/2; i++){
      int[]temp;
      temp = matrix[i];
      matrix[i] = matrix[n-i-1];
      matrix[n-i-1] = temp;
    }
  }
}
/*
  123
  456
  789

  ->

  963
  852
  741

  ->

  741
  852
  963

 */

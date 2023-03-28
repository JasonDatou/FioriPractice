package ssicf.leetcode2022;

public class Searcha2DMatrix {
  public static void main(String[] args) {
    Searcha2DMatrixSolution s = new Searcha2DMatrixSolution();
    int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    boolean result = s.searchMatrix(matrix, 3);
    System.out.println(result);
  }
}

class Searcha2DMatrixSolution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int length = matrix.length * matrix[0].length;
    return binaySearch(0, length - 1, target, matrix) != -1;
  }

  private int binaySearch(int from, int to, int target, int[][] nums) {
    //  1 2 3 4
    //  5 6 7 8
    //
    int mid = (from + to) / 2;
    int i = mid / nums[0].length;
    int j = mid % nums[0].length;

    int num = nums[i][j];
    if (num == target)
      return mid;
    if (from >= to)
      return -1;
    else if (num > target)
      return binaySearch(from, mid - 1, target, nums);
    else
      return binaySearch(mid + 1, to, target, nums);
  }
}

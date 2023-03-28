package ssicf.leetcode2022;

public class FindNumberIn2DArray {
  public static void main(String[] args) {
    FindNumberIn2DArraySolution s = new FindNumberIn2DArraySolution();
    int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
    boolean result = s.findNumberIn2DArray(matrix, 20);
    System.out.println(result);
  }
}

class FindNumberIn2DArraySolution {
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0)
      return false;
    int n = matrix[0].length;
    if (n == 0)
      return false;
    for (int i = 0; i < m; i++) {
      if (binarySearch(matrix[i], 0, n - 1, target) >= 0)
        return true;
    }
    return false;
  }

  private int binarySearch(int[] nums, int start, int end, int target) {
    int mid = (start + end) / 2;
    if (nums[mid] == target)
      return mid;
    if (start > end)
      return -1;
    else if (nums[mid] < target) {
      return binarySearch(nums, mid + 1, end, target);
    } else if (nums[mid] > target) {
      return binarySearch(nums, start, mid - 1, target);
    }
    return -1;
  }
}

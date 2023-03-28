package ssicf.leetcode2022;

public class MinimumPathSum {
  public static void main(String[] args) {
    MinimumPathSumSolution s = new MinimumPathSumSolution();
    int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}};
    int gridult = s.minPathSum(grid);
    System.out.println(gridult);
  }
}

class MinimumPathSumSolution {
  public int minPathSum(int[][] grid) {
    int m = grid[0].length;
    int n = grid.length;
    for (int i = 1; i < m; i++) {
      grid[0][i] = grid[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < n; i++) {
      grid[i][0] = grid[i - 1][0] + grid[i][0];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        grid[j][i] = Math.min(grid[j - 1][i], grid[j][i - 1]) + grid[j][i];
      }
    }
    return grid[n - 1][m - 1];
  }
}

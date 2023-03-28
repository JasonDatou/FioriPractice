package ssicf.contest.contest299;


class Queston1 {
  public static void main(String[] args) {
    Queston1Solution s = new Queston1Solution();
    int[][] grid = new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
    boolean result = s.checkXMatrix(grid);
    System.out.println(result);
  }
}

class Queston1Solution {
  public boolean checkXMatrix(int[][] grid) {
    int n = grid.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i + j == (n - 1) || i == j) {
          if (grid[i][j] == 0)
            return false;
        } else {
          if (grid[i][j] != 0)
            return false;
        }
      }
    }
    return true;
  }
}

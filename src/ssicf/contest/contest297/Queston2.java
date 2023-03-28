package ssicf.contest.contest297;


class Queston2 {
  public static void main(String[] args) {
    Queston2Solution s = new Queston2Solution();
    int[][] grid = new int[][]{{5, 3}, {4, 0}, {2, 1}};
//                              0,0/0,1  1,0/1,1  2,0/2,1  3,0/3,1  4,0/4,1  5,0/5,1
    int[][] moveCost = new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
    int result = s.minPathCost(grid, moveCost);
    System.out.println(result);
  }
}

//"abbaccaddaeea"
//    "aaaaa"

class Queston2Solution {
  int sum = 0;
  int res = Integer.MAX_VALUE;

  public int minPathCost(int[][] grid, int[][] moveCost) {
    buidPath(grid, 0, moveCost, -1);
    return res;
  }

  private void buidPath(int[][] grid, int level, int[][] moveCost, int parent) {
    if (level == grid.length) {
      res = Math.min(res, sum);
      return;
    }
    if (sum > res)
      return;
    for (int i = 0; i < grid[level].length; i++) {
      int cost = 0;
      if (level > 0)
        cost = moveCost[parent][i];
      sum += (grid[level][i] + cost);
      buidPath(grid, level + 1, moveCost, grid[level][i]);
      sum -= (grid[level][i] + cost);
    }
  }
}

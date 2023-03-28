package ssicf.leetcode2022;

public class UniquePathsII {
  public static void main(String[] args) {
    UniquePathsIISolution s = new UniquePathsIISolution();
    int[][] obstacleGrid = new int[][]{{0}};
    int result = s.uniquePathsWithObstacles(obstacleGrid);
    System.out.println(result);
  }
}

class UniquePathsIISolution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid[0][0] == 1)
      return 0;

    int m = obstacleGrid[0].length;
    int n = obstacleGrid.length;

    int rowValue = 1;
    for (int i = 0; i < m; i++) {
      if (obstacleGrid[0][i] == 1)
        rowValue = 0;
      obstacleGrid[0][i] = rowValue;
    }

    int columnValue = 1;
    for (int i = 1; i < n; i++) {
      if (obstacleGrid[i][0] == 1)
        columnValue = 0;
      obstacleGrid[i][0] = columnValue;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[j][i] == 1)
          obstacleGrid[j][i] = 0;
        else
          obstacleGrid[j][i] = obstacleGrid[j - 1][i] + obstacleGrid[j][i - 1];
      }
    }
    return obstacleGrid[n - 1][m - 1];
  }
}

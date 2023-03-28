package ssicf.leetcode2022;

public class MovingCount {
  public static void main(String[] args) {
    MovingCountSolution s = new MovingCountSolution();
    int result = s.movingCount(30, 16, 9);
    System.out.println(result);
  }
}

class MovingCountSolution {
  public int movingCount(int m, int n, int k) {
    if (k == 0) {
      return 1;
    }
    boolean[][] vis = new boolean[m][n];
    int ans = 1;
    vis[0][0] = true;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if ((i == 0 && j == 0) || plus(i, j) > k) {
          continue;
        }
        // 边界判断
        if (i - 1 >= 0) {
          vis[i][j] |= vis[i - 1][j];
        }
        if (j - 1 >= 0) {
          vis[i][j] |= vis[i][j - 1];
        }
        ans += vis[i][j] ? 1 : 0;
      }
    }
    return ans;
  }

  int plus(int x, int y) {
    int sum = 0;
    while (x > 0) {
      sum += x % 10;
      x /= 10;
    }
    while (y > 0) {
      sum += y % 10;
      y /= 10;
    }
    return sum;
  }
}

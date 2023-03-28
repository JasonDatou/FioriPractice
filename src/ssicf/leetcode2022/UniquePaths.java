package ssicf.leetcode2022;

public class UniquePaths {
  public static void main(String[] args){
    UniquePathsSolution s = new UniquePathsSolution();
    int result = s.uniquePaths(1,1);
    System.out.println(result);
  }
}

class UniquePathsSolution {
  public int uniquePaths(int m, int n) {
    int[][] path = new int[n][m];
    for (int i = 0; i < m; i++) {
      path[0][i] = 1;
    }
    for (int i = 1; i < n; i++) {
      path[i][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        path[j][i] = path[j - 1][i] + path[j][i - 1];
      }
    }
    return path[n - 1][m - 1];
  }
}

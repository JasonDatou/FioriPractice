package ssicf.leetcode2022;

public class WordSearch {
  public static void main(String[] args) {
    WordSearchSolution s = new WordSearchSolution();
    char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    boolean result = s.exist(board, "BFD");
    System.out.println(result);
  }
}

// A B C E
// S F C S
// A D E E

class WordSearchSolution {
  int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  public boolean exist(char[][] board, String word) {
    int h = board.length,
        w = board[0].length;
    boolean[][] visited = new boolean[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        boolean flag = check(board, visited, i, j, word, 0);
        if (flag) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
    if (board[i][j] != s.charAt(k))
      return false;
    else {
      if (k == s.length() - 1)
        return true;
      visited[i][j] = true;
      for (int[] ints : direction) {
        int nextI = i + ints[0];
        int nextJ = j + ints[1];
        if (nextI < board.length && nextI >= 0 && nextJ < board[0].length && nextJ >= 0
            && !visited[nextI][nextJ]) {
          if (check(board, visited, nextI, nextJ, s, k + 1))
            return true;
        }
      }
      visited[i][j] = false;
      return false;
    }
  }
}

package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
  public static void main(String[] args) {
    NQueensSolution s = new NQueensSolution();
    List<List<String>> result = s.solveNQueens(1);
    System.out.println(result);
  }
}

class NQueensSolution {
  List<List<String>> res = new ArrayList<>();
  List<String> temp = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    // initialize
    String[] rows = new String[n];
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < i; j++) {
        sb.append('.');
      }
      sb.append('Q');
      for (int j = i + 1; j < n; j++) {
        sb.append('.');
      }
      rows[i] = sb.toString();
    }
    boolean[] usedList = new boolean[n];
    backTrack(n, rows, usedList);
    return res;
  }


  void backTrack(int n, String[] rows, boolean[] usedList) {
    if (!validate(temp, n))
      return;
    if (temp.size() == n) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (usedList[i])
        continue;
      usedList[i] = true;
      temp.add(rows[i]);
      backTrack(n, rows, usedList);
      temp.remove(temp.size() - 1);
      usedList[i] = false;
    }

  }

  boolean validate(List<String> temp, int n) {
    int size = temp.size();
    if (size <= 1)
      return true;
    String lastRow = temp.get(size - 1);
    int QinLastRow = 0;
    for (int i = 0; i < n; i++) {
      if (lastRow.charAt(i) == 'Q') {
        QinLastRow = i;
        break;
      }
    }
    for (int i = 0; i < size - 1; i++) {
      if (temp.get(i).charAt(QinLastRow) == 'Q')
        return false;
    }
    // check left
    for (int i = 0; i < QinLastRow; i++) {
      if (size - 2 - i >= 0 && temp.get(size - 2 - i).charAt(QinLastRow - i - 1) == 'Q')
        return false;
    }
    // check left
    for (int i = 0; i < n - 1 - QinLastRow; i++) {
      if (size - 2 - i >= 0 && temp.get(size - 2 - i).charAt(QinLastRow + i + 1) == 'Q')
        return false;
    }
    return true;
  }
}

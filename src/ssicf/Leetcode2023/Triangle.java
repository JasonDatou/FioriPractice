package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
  public static void main(String[] args) {
    TriangleSolution s = new TriangleSolution();
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    int result = s.minimumTotal(triangle);
    System.out.println(result);
  }
}

class TriangleSolution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<List<Integer>> res = new ArrayList<>(triangle);
    for (int i = 1; i < res.size(); i++) {
      List<Integer> preRow = res.get(i - 1);
      List<Integer> row = res.get(i);
      row.set(0, row.get(0) + preRow.get(0));
      for (int j = 1; j < row.size() - 1; j++) {
        row.set(j, row.get(j) + Math.min(preRow.get(j), preRow.get(j - 1)));
      }
      int lastIndex = row.size() - 1;
      row.set(lastIndex, row.get(lastIndex) + preRow.get(lastIndex - 1));
    }
    List<Integer> lastRow = res.get(res.size() - 1);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < lastRow.size(); i++) {
      min = Math.min(min, lastRow.get(i));
    }
    return min;
  }
}
package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
  public static void main(String[] args) {
    InsertIntervalSolution s = new InsertIntervalSolution();
    int[][] intervals = new int[][]{{1, 3}, {6, 9}};
    int[] newinterval = new int[]{2, 5};
    int[][] result = s.insert(intervals, newinterval);
    System.out.println(Arrays.deepToString(result));
  }
}

class InsertIntervalSolution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] intervals2 = Arrays.copyOf(intervals, intervals.length + 1);
    intervals2[intervals.length] = newInterval;
    Arrays.sort(intervals2, Comparator.comparing(a -> a[0]));
    List<int[]> res = new ArrayList<>();

    res.add(intervals2[0]);
    for (int i = 1; i < intervals2.length; i++) {
      int[] last = res.get(res.size() - 1);
      if (last[1] >= intervals2[i][0]) {
        last[1] = Math.max(last[1], intervals2[i][1]);
        continue;
      }
      res.add(intervals2[i]);
    }
    return res.toArray(new int[0][0]);
  }
}

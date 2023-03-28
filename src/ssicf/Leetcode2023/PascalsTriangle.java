package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import ssicf.commons.ListNode;

public class PascalsTriangle {
  public static void main(String[] args) {
    PascalsTriangleSolution s = new PascalsTriangleSolution();
    List<List<Integer>> result = s.generate(5);
    System.out.println(result);
  }
}

class PascalsTriangleSolution {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> generate(int numRows) {
    for (int i = 1; i <= numRows; i++) {
      res.add(gen(i));
    }
    return res;
  }

  List<Integer> gen(int n) {
    List<Integer> temp = new ArrayList<>();
    if (n <= 2) {
      for (int i = 0; i < n; i++) {
        temp.add(1);
      }
      return temp;
    } else {
      List<Integer> pre = res.get(n - 2);
      temp.add(1);
      for (int i = 1; i <= n / 2; i++) {
        temp.add(pre.get(i - 1) + pre.get(i));
      }
      for (int i = n / 2 + 1; i < n; i++) {
        temp.add(temp.get(n - i - 1));
      }
    }
    return temp;
  }
}
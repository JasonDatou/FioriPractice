package ssicf.contest.contest294;


import java.util.Arrays;
import java.util.Comparator;

class Minline {
  public static void main(String[] args) {
    MinlineSolution s = new MinlineSolution();
    int[][] stockPrices = new int[][]{{1, 1000000000}, {1000000000, 1000000000}, {999999999, 1}, {2, 999999999}};
    int result = s.minimumLines(stockPrices);
    System.out.println(result);
  }
}

class MinlineSolution {
  public int minimumLines(int[][] stockPrices) {
    Arrays.sort(stockPrices, Comparator.comparing(a -> a[0]));
    int res = 0;
    double prexielv = -999;
    for (int i = 1; i < stockPrices.length; i++) {
      double currxielv = (double) (stockPrices[i][1] - stockPrices[i - 1][1]) / (double) (stockPrices[i][0] - stockPrices[i - 1][0]);
      if (i == 1) {
        res = 1;
        prexielv = currxielv;
      } else {
        if (currxielv != prexielv) {
          res++;
          prexielv = currxielv;
        }
      }
    }
    return res;
  }
}

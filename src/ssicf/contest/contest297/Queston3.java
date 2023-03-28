package ssicf.contest.contest297;


import java.util.Arrays;

class Queston3 {
  public static void main(String[] args) {
    Queston3Solution s = new Queston3Solution();
    int[][] brackets = new int[][]{{3, 50}, {7, 10}, {12, 25}};
    double result = s.calculateTax(brackets, 10);
    System.out.println(result);
  }
}

class Queston3Solution {
  public double calculateTax(int[][] brackets, int income) {
    double res = 0;
    int rest = income;
    Arrays.sort(brackets, (o1, o2) -> {
      return o1[0] - o2[0];
    });
    for (int i = 0; i < brackets.length; i++) {
      if (income <= brackets[i][0]) {
        res += ((double) rest * brackets[i][1] / 100);
        break;
      } else {
        if (i > 0)
          res += ((double) (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] / 100);
        else
          res += ((double) brackets[i][0] * brackets[i][1] / 100);
        rest = income - brackets[i][0];
      }
    }
    return res;
  }
}

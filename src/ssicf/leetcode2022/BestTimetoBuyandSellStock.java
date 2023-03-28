package ssicf.leetcode2022;

public class BestTimetoBuyandSellStock {
  public static void main(String[] args) {
    BestTimetoBuyandSellStockSolution s = new BestTimetoBuyandSellStockSolution();
    int[] nums = new int[]{7, 1, 5, 3, 6, 4};
    int result = s.maxProfit(nums);
    System.out.println(result);
  }
}

class BestTimetoBuyandSellStockSolution {
  public int maxProfit(int[] prices) {
    int res = 0;
    int[] right = new int[prices.length];
    right[right.length - 1] = prices[prices.length - 1];
    for (int i = prices.length - 2; i > 0; i--) {
      right[i] = Math.max(prices[i], right[i + 1]);
    }
    for (int i = 0; i < prices.length-1; i++) {
      res = Math.max(res, right[i + 1] - prices[i]);
    }
    return res;
  }
}

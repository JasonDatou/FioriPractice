package ssicf.leetcode2022;

public class BestTimetoBuyandSellStockII {
  public static void main(String[] args) {
    BestTimetoBuyandSellStockIISolution s = new BestTimetoBuyandSellStockIISolution();
    int[] nums = new int[]{7, 1, 5, 3, 6, 4};
    int result = s.maxProfit(nums);
    System.out.println(result);
  }
}

class BestTimetoBuyandSellStockIISolution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;
    int ans = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {  // 卖出有利可图
        ans += (prices[i] - prices[i - 1]);
      }
    }
    return ans;
  }
}

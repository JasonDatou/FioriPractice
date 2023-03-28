package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FinalPricesWithaSpecialDiscountinaShop {
  public static void main(String[] args) {
    FinalPricesWithaSpecialDiscountinaShopSolution s = new FinalPricesWithaSpecialDiscountinaShopSolution();
    int[] prices = new int[]{8, 4, 6, 2, 3};
    int[] result = s.finalPrices(prices);
    System.out.println(Arrays.toString(result));
  }
}

class FinalPricesWithaSpecialDiscountinaShopSolution {
  public int[] finalPrices(int[] prices) {
    int[] res = new int[prices.length];
    Deque<Integer> monostack = new ArrayDeque<>();

    for (int i = 0; i < prices.length; i++) {
      while (!monostack.isEmpty() && prices[monostack.peek()] >= prices[i]) {
        int index = monostack.pop();
        res[index] = prices[index] - prices[i];
      }
      monostack.push(i);
    }
    while (!monostack.isEmpty()) {
      int index = monostack.pop();
      res[index] = prices[index];
    }
    return res;
  }
}

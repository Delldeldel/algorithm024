package com.wkx.demo.week4;

/**
 * 买卖股票最佳时机
 */
public class MaxProfit {

  public static void main(String[] args) {
    int[] bills = new int[]{1, 2, 3, 4, 5};
    MaxProfit l = new MaxProfit();
    System.out.println(l.maxProfit(bills));
  }

  public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[i + 1]) {
        profit += prices[i + 1] - prices[i];
      }

    }
    return profit;
  }
}

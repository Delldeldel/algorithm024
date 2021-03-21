package com.wkx.demo.week7;

/**
 * 爬楼梯
 */
public class ClimbStairs {
  public int climbStairs(int n) {
    if (n <= 1) return n;
    int[] dp = new int[3];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      int sum = dp[1] + dp[2];
      dp[1] = dp[2];
      dp[2] = sum;
    }
    return dp[2];
  }
}

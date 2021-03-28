package com.wkx.week8;

public class HammingWeight {
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; ++i) {
      count += n & 1;
      n >>= 1;
    }
    return count;
  }

  public int hammingWeight2(int n) {
    return n == 0 ? 0 : hammingWeight((n & (~n + 1)) ^ n) + 1;
  }

}
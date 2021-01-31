package com.wkx.demo;

import java.util.Arrays;

public class DailyTemperatures {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(dailyTemperatures(new int[]{13,99,78,12,56})));
  }

  //股票
  public static int[] dailyTemperatures(int[] T) {

    int count = 0;
    int[] march = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      for (int j = i + 1; j < T.length; j++) {
        if (T[i] < T[j]) {
          march[i] += count + 1;
          break;
        } else {
          count++;
        }
      }
      count =0;
    }
    return march;
  }
}

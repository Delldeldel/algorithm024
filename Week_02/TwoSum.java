package com.wkx.demo;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> saveMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int findNum = target - nums[i];
      if (saveMap.get(findNum) != null) {
        return new int[]{i, saveMap.get(findNum)};
      }
      saveMap.put(nums[i], i);
    }
    return null;

  }
}

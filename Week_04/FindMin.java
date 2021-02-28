package com.wkx.demo.week4;

import java.util.Arrays;

/**
 * 寻找旋转排序数组中的最小值
 */
public class FindMin {
  public static void main(String[] args) {
    FindMin f = new FindMin();
    int result = f.findMin(new int[]{2,1});
    System.out.println(result);
  }

  public int findMin(int[] nums) {
    if (nums.length ==1) return nums[0];
    int min = findMinInMid(nums);
    return min;
  }

  private int findMinInMid(int[] nums) {
    int l = nums.length;
    int mid = (int) Math.ceil(l / 2);
    int min = nums[0];
    if (nums[0] > nums[mid]) {
      min = findMinInMid(Arrays.copyOfRange(nums, 1,mid + 1));
    } else if (nums[l - 1] < nums[mid]) {
      min = findMinInMid(Arrays.copyOfRange(nums, mid + 1, l));
    }
    return min;
  }

  ;
}

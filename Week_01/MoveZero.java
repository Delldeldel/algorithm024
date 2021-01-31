package com.wkx.demo;

import java.util.Arrays;

public class MoveZero {
  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 0, 3, 12};
    moveZero(nums);
    System.out.println(Arrays.toString(nums));
    int[] nums2 = new int[]{-2, 1, 0, -3, 3, 12};
    moveJustZero(nums2);
    System.out.println(Arrays.toString(nums2));


    int[] nums3 = new int[]{-2, 1, 0, -3, 3, 12};
    moveLessZero(nums3);
    System.out.println(Arrays.toString(nums3));
    int[] nums4 = new int[]{-2, 1, 0, -3, 3, 12};
    moveZero(nums4);
    System.out.println(Arrays.toString(nums4));
  }

  //和去重类似，运用双指针，但是保存了慢指针的值
  public static void moveZero(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        j++;
      }
    }
  }

  //需要后移的值给定时，可以直接给后移的位置赋值，有点取巧
  public static void moveJustZero(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        count++;
        continue;
      } else {
        nums[i - count] = nums[i];
      }
    }
    for (int i = 1; i <= count; i++) {
      nums[nums.length - i] = 0;

    }
  }

  //如果针对不大于0的值后移，moveJustZero()失效,不如第一种方法，但是第一种置换又打乱原有元素位置。。。
  public static void moveLessZero(int[] nums) {
    int count = 0;
    int[] saveNums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0) {
        saveNums[count] = nums[i];
        count++;
        continue;
      } else {
        nums[i - count] = nums[i];
      }
    }
    for (int i = 1; i <= count; i++) {
      nums[nums.length - i] = saveNums[count - i];
    }
  }


}

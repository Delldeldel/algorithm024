package com.wkx.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class RotateArray {
  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotateWithoutBrain(nums1, 10);
    System.out.println(Arrays.toString(nums1));

    int[] nums2 = new int[]{-1, -100, 3, 99};
    rotateWhithLinkedList(nums2, 2);
    System.out.println(Arrays.toString(nums2));

    int[] nums3 = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotate(nums3, 3);
    System.out.println(Arrays.toString(nums3));


  }

  //将前n-k个数后移k位，将后k个数给前k个
  public static void rotateWithoutBrain(int[] nums, int k) {
    k = k % nums.length;
    if (k == 0) return;
    int[] lastKNums = new int[k];
    for (int i = 0; i < k; i++) {
      lastKNums[k - 1 - i] = nums[nums.length - 1 - i];
    }
    for (int j = nums.length - 1; j >= 0; j--) {
      if (j < k) {
        nums[j] = lastKNums[j];
      } else {
        nums[j] = nums[j - k];
      }
    }
    //n+k
  }


  public static void rotateWhithLinkedList(int[] nums, int k) {
    k = k % nums.length;
    if (k == 0) return;
    LinkedList<Integer> linkedNums = new LinkedList();
    for (int i = 0; i < nums.length; i++) {
      linkedNums.add(nums[i]);

    }
    for (int i = 0; i < k; i++) {
      linkedNums.addFirst(linkedNums.pollLast());
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = linkedNums.pollFirst();
    }
    //2n+k
    //环形链表。。
  }

  //反转 反转 反转
  public static void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public static  void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}

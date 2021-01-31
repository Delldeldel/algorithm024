package com.wkx.demo;

import java.util.Arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    mergeWithoutBrain(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    mergeWithDoublePointer(new int[]{2, 0}, 1, new int[]{1}, 1);
  }

  /* 作者：LeetCode
   链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
   来源：力扣（LeetCode）
   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
    System.out.println(Arrays.toString(nums1));

  }


  public static void mergeWithoutBrain(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n + m; i++) {
      if (i >= m) {
        nums1[i] = nums2[i - m];
      }
    }
    Arrays.sort(nums1);
    System.out.println(Arrays.toString(nums1));
  }

  public static void mergeWithDoublePointer(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0;
    int[] temp = Arrays.copyOf(nums1, m);
    for (int k = 0; k < n + m; k++) {
      if (m == 0) {
        nums1 = nums2;
        break;
      }
      if (n == 0) break;
      if (i < m && j < n) {
        if (temp[i] <= nums2[j]) {
          nums1[k] = temp[i++];
        } else {
          nums1[k] = nums2[j++];
        }
      } else if (j > n && i < m) {
        nums1[k] = temp[i++];
      } else if (j < n && i > m) {
        nums1[k] = nums2[j++];
      }

    }
    System.out.println(Arrays.toString(nums1));
  }

}

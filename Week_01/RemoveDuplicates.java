package com.wkx.demo;


import java.util.HashSet;

public class RemoveDuplicates {
  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    System.out.println(removeDuplicatesNotTogether(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

  }

  /*此时数组中没有重复元素，按照上面的方法，每次比较时 nums[p] 都不等于 nums[q]，因此就会将 q 指向的元素原地复制一遍，这个操作其实是不必要的。

  因此我们可以添加一个小判断，当 q - p > 1 时，才进行复制。

  作者：max-LFszNScOfE
  链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
 */
  //i指针指向被比对元素，j指针快速向后推，重复元素忽略，不同元素赋给下一个被比对位,原比对位失效
  public static int removeDuplicates(int[] nums) {
    if (nums.length < 1) return nums.length;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        if (i != j) nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  //假如重复元素不在一起，j指针失效后对已出现的重复元素无法校验
  public static int removeDuplicatesNotTogether(int[] nums) {
    if (nums.length < 1) return nums.length;
    int i = 0;
    HashSet<Integer> numSet = new HashSet<>();
    numSet.add(nums[0]);
    for (int j = 1; j < nums.length && j > i; j++) {
      if (!numSet.contains(nums[j])) {
        i++;
        if (i != j) nums[i] = nums[j];
        numSet.add(nums[i]);
      }
    }
    return i + 1;
  }

}

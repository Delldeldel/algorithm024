package com.wkx.demo;

public class Trap {
  public static void main(String[] args) {
    System.out.println(trap(new int[]{4,2,0,3,2,5}));
  }


  public static int trap(int[] height) {
    int i = 0, j = height.length - 1;
    int sum = 0;
    int max = 0;
    int leftSum = 0, leftHeight = 0;
    int rightSum = 0, rightHeight = 0;

    for (int k = 0; k <= j; k++) {
      max = height[max] > height[k] ? max : k;
    }
    while (i < j) {
      if (i < max) {// (leftHeight< rightHeight) 替代
        if (height[i] > leftHeight) {
          leftHeight = height[i];
          leftSum += leftHeight;
          sum += height[i];
          i++;
        } else {
          leftSum += leftHeight;
          sum += height[i];
          i++;
        }
      }
      if (j > max) {
        if (height[j] > rightHeight) {
          rightHeight = height[j];
          rightSum += rightHeight;
          sum += height[j];
          j--;
        } else {
          rightSum += rightHeight;
          sum += height[j];
          j--;
        }
      }

    }
    return rightSum + leftSum - sum;

  }
/*

  作者：LeetCode
  链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
  public int trapCnLeetCode(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= left_max) {
          left_max = height[left];
        } else {
          ans += (left_max - height[left]);
        }
        ++left;
      } else {
        if (height[right] >= right_max) {
          right_max = height[right];
        } else {
          ans += (right_max - height[right]);
        }
        --right;
      }
    }
    return ans;
  }
  
  //滑动窗口？？


}

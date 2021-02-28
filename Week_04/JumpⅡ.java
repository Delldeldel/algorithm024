package com.wkx.demo.week4;

/**
 * 跳跃Ⅱ
 */
public class JumpⅡ {
  public static void main(String[] args) {
    JumpⅡ j = new JumpⅡ();
    System.out.println(j.jump2(new int[]{2, 3, 1, 1, 4}));
  }

  public int jump(int[] nums) {
    int position = nums.length - 1;
    int steps = 0;
    while (position > 0) {
      for (int i = 0; i < nums.length - 1; i++) {
        if (i + nums[i] >= position) {
          steps++;
          position = i;
          break;
        }
      }
    }
    return steps;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int jump2(int[] nums) {
    int length = nums.length;
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < length - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);//可以跳跃最远位置
      if (i == end) {//达到上次记录的最远位置，记录跳越次数，此时最远距离记录
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }


}

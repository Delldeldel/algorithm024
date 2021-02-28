package com.wkx.demo.week4;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class FindContentChildren {
  public static void main(String[] args) {
    int[] g = new int[]{1, 2, 3};
    int[] s = new int[]{1, 2};
    FindContentChildren l = new FindContentChildren();
    System.out.println(l.findContentChildren(g, s));
  }

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int which = 0, count = 0;
    for (int i = 0; i < g.length; i++) {
      while (which < s.length && g[i] > s[which]) {
        which++;
      }
      if (which >= s.length) break;
      if (g[i] <= s[which]) {
        which++;
        count++;
      }
    }
    return count;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/assign-cookies/solution/fen-fa-bing-gan-by-leetcode-solution-50se/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param g
   * @param s
   * @return
   */

  public int findContentChildren2(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int numOfChildren = g.length, numOfCookies = s.length;
    int count = 0;
    for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
      while (j < numOfCookies && g[i] > s[j]) {
        j++;
      }
      if (j < numOfCookies) {
        count++;
      }
    }
    return count;
  }


}

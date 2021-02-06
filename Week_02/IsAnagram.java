package com.wkx.demo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
  public static void main(String[] args) {
    String s = "anagram", t = "nagaram";
    System.out.println(isAnagramHHH(s, t));
    String s1 = "rat", t1 = "car";
    System.out.println(isAnagramHHH(s1, t1));
  }

  public static boolean isAnagramHHH(String s, String t) {
    if (s.length() != t.length()) return false;
    String[] sArrary = s.split("");
    String[] tArrary = t.split("");
    Arrays.sort(sArrary);
    Arrays.sort(tArrary);
    if (Arrays.equals(tArrary,sArrary)) {
      return true;
    }
    return false;
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    String[] sArrary = s.split("");
    String[] tArrary = t.split("");
    Map<String, Integer> numCountMap = new HashMap();
    for (int i = 0; i < s.length(); i++) {
      if (numCountMap.get(sArrary[i]) != null) numCountMap.put(sArrary[i], numCountMap.get(sArrary[i]) + 1);
      else numCountMap.put(sArrary[i], 1);
      if (numCountMap.get(tArrary[i]) != null) numCountMap.put(tArrary[i], numCountMap.get(tArrary[i]) - 1);
      else numCountMap.put(tArrary[i], -1);
    }
    for (Integer count : numCountMap.values()) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }


  /*作者：LeetCode-Solution
  链接：https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
  public boolean isAnagramWithArrary(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
      table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      table[t.charAt(i) - 'a']--;
      if (table[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

}

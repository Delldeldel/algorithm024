package com.wkx.demo;

import java.util.*;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap();
    for (int i = 0; i < strs.length; i++) {
      String[] sWord = strs[i].split("");
      Arrays.sort(sWord);
      List<String> list = map.getOrDefault(Arrays.toString(sWord), new ArrayList<>());
      list.add(strs[i]);
      map.put(Arrays.toString(sWord), list);
    }
    return new ArrayList<>(map.values());


  }
  public List<List<String>> groupAnagramsGlobal(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] ca = new char[26];
      for (char c : s.toCharArray()) ca[c - 'a']++;
      String keyStr = String.valueOf(ca);
      if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
      map.get(keyStr).add(s);
    }
    return new ArrayList<>(map.values());
  }
}

package com.wkx.demo.week7;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    List result = new ArrayList();
    dfs("", 0, n, n, result);
    return result;
  }

  private void dfs(String s, int level, int left, int right, List<String> result) {
    if (left == 0 && right == 0) {
      result.add(s);
      return;
    }
    if (right > 0 && level > 0) {
      String addRight = s + ")";
      dfs(addRight, level - 1, left, right - 1, result);
    }
    if (left > 0) {
      String addLeft = s + "(";
      dfs(addLeft, level + 1, left - 1, right, result);
    }
  }

}

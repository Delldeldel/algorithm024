package com.wkx.demo.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后 我不会。。。
 */
public class SolveNQueens {
  class Solution {
    private List<List<String>> results;

    //主方法
    public List<List<String>> solveNQueens(int n) {
      results = new ArrayList<>();
      int[] queens = new int[n];
      solveNQueens(queens, n, 0, 0, 0, 0);
      return results;
    }


    //回溯方法
    public void solveNQueens(int[] queens, int n, int row, int column, int diagonals1, int diagonals2) {
      //回溯
      if (row == n) {
        results.add(generateString(queens));
        return;
      }
      //某位为1表示改行的某列可选（低位对应方格左）
      int availableLocations = ((1 << n) - 1) & (~(column | diagonals1 | diagonals2));
      //更新可选斜边。棋盘方格移动方向与二进制数位移动方向相反
      diagonals1 <<= 1;
      diagonals2 >>= 1;
      //当前仍有可选方格时
      while (availableLocations != 0) {
        //定位到当前行最左可选方格(提取出可选串中的最低位1作为当前选取对象)
        int position = availableLocations & (-1 * availableLocations);
        //记录下该方格的行内索引
        int columnNum = Integer.bitCount(position - 1);
        queens[row] = columnNum;
        //当前被选的方格置为不可再选(将availableLocations中的最低位1置0)
        availableLocations &= (availableLocations - 1);
        //进行下一行的选择
        solveNQueens(queens, n, row + 1, column | position,
            diagonals1 | (position << 1), diagonals2 | (position >> 1));
      }
    }

    //生成皇后位置字符串方法
    public List<String> generateString(int[] queens) {
      List<String> result = new ArrayList<>();
      for (int queen : queens) {
        char[] chars = new char[queens.length];
        Arrays.fill(chars, '.');
        chars[queen] = 'Q';
        result.add(String.valueOf(chars));
      }
      return result;
    }
  }
}

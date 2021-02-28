package com.wkx.demo.week4;

import java.util.Arrays;

/**
 * 岛屿问题
 */
public class NumIslands {

  public static void main(String[] args) {
    char[][] grid = new char[][]
        {{'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};
    NumIslands f = new NumIslands();
    System.out.println(f.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          deleteIsland(i, j, grid);
        }

      }
    }
    return count;
  }

  public void deleteIsland(int i, int j, char[][] grid) {

    if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    deleteIsland(i - 1, j, grid);
    deleteIsland(i, j - 1, grid);
    deleteIsland(i + 1, j, grid);
    deleteIsland(i, j + 1, grid);
  }
}

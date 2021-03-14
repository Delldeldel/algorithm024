package week6;

public class MinPathSum {
  public static void main(String[] args) {
    MinPathSum thisMethod = new MinPathSum();
    System.out.println(thisMethod.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int path[][] = new int[grid.length][grid[0].length];
    path[0][0] = grid[0][0];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (i > 0 && j == 0) {
          path[i][j] = path[i - 1][0] + grid[i][j];

        } else if (j > 0 && i == 0) {
          path[i][j] = path[0][j - 1] + grid[i][j];

        } else if (j > 0 && i > 0) {
          path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
        }
      }
    }
    return path[grid.length - 1][grid[0].length - 1];


  }
}

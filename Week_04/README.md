学习笔记
1.深度优先dfs/广度优先bfs
dfs：
<span>
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
      return allResults;
    }
    travel(root, 0, allResults);
    return allResults;
  }

  public void travel(TreeNode root, int level, List<List<Integer>> allResults) {
    if (allResults.size() == level) {
      allResults.add(new ArrayList<>());
    }
    allResults.get(level).add(root.val);
    if (root.left != null) {
      travel(root.left, level + 1, allResults);
    }
    if (root.right != null) {
      travel(root.right, level + 1, allResults);
    }
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
</span>
BFS:
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
      return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      List<Integer> results = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.poll();
        results.add(node.val);
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
      }
      allResults.add(results);
    }
    return allResults;
  }
2.贪心法
特定问题: 分解子问题，局部最优解集成全局最优解
3.二分法
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
      mid = (right - left) / 2 + left;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
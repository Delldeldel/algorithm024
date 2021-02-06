package com.wkx.demo;

import java.util.*;

public class InorderTraversal {
  /*作者：LeetCode-Solution
  链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

  public List<Integer> inorderTraversalLeetCode2(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Stack<TreeNode> stk = new Stack<TreeNode>();
    while (root != null || !stk.isEmpty()) {
      while (root != null) {
        stk.push(root);
        root = root.left;
      }
      root = stk.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }



  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    if (root == null) return result;
    putVal(result, root);
    return result;
  }

  private void putVal(List<Integer> list, TreeNode node) {
    if (node == null) {
      return;
    }
    putVal(list, node.left);
    list.add(node.val);
    putVal(list, node.right);
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
}

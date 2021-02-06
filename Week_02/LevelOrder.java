package com.wkx.demo;

import java.util.*;

public class LevelOrder {
  /*作者：LeetCode
  链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        queue.addAll(node.children);
      }
      result.add(level);
    }
    return result;
  }

 /* 作者：LeetCode
  链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


  public List<List<Integer>> levelOrder2(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    List<Node> previousLayer = Arrays.asList(root);

    while (!previousLayer.isEmpty()) {
      List<Node> currentLayer = new ArrayList<>();
      List<Integer> previousVals = new ArrayList<>();
      for (Node node : previousLayer) {
        previousVals.add(node.val);
        currentLayer.addAll(node.children);
      }
      result.add(previousVals);
      previousLayer = currentLayer;
    }

    return result;
  }

  /*作者：LeetCode
  链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> levelOrder3(Node root) {
    if (root != null) traverseNode(root, 0);
    return result;
  }

  private void traverseNode(Node node, int level) {
    if (result.size() <= level) {
      result.add(new ArrayList<>());
    }
    result.get(level).add(node.val);
    for (Node child : node.children) {
      traverseNode(child, level + 1);
    }
  }

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  ;

}

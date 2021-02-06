package com.wkx.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NTreePreorder {

//  作者：LeetCode
//  链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/ncha-shu-de-qian-xu-bian-li-by-leetcode/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  public List<Integer> preorderLeetCode(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
      Node node = stack.pollLast();
      output.add(node.val);
      Collections.reverse(node.children);
      for (Node item : node.children) {
        stack.add(item);
      }
    }
    return output;
  }



  public List<Integer> preorder(Node root) {
    List<Integer> resultList = new ArrayList<>();
    if (root == null) return resultList;
    resultList.add(root.val);
    putChildVal(resultList, root);
    return resultList;


  }

  private void putChildVal(List<Integer> resultList, Node child) {
    if (child != null && child.children != null) {
      for (Node node : child.children) {
        resultList.add(node.val);
        putChildVal(resultList, node);
      }
    }

  }

  class Node {
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

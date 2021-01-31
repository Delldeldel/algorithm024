package com.wkx.demo;

public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode newListNode = new ListNode(0);
    ListNode pre = newListNode;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
    }
    if (l1 != null) {
      pre.next = l1;
    } else {
      pre.next = l2;
    }
    return newListNode.next;
  }


  public ListNode mergeTwoListsWhithRecursion(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoListsWhithRecursion(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListsWhithRecursion(l1, l2.next);
      return l2;
    }
  }

  /*
   * 升序   l1嵌套循环l2
   * n*m
   * */


  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}

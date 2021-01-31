package com.wkx.demo;

public class MyCircularDeque {
  private DoubleListNode head;
  private DoubleListNode tail;
  private int k;
  private int size;


  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public MyCircularDeque(int k) {
    head = new DoubleListNode(-1);
    tail = new DoubleListNode(-1);
    this.k = k;
    this.size = 0;

  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (size < k) {

      DoubleListNode newHead = new DoubleListNode(value);
      newHead.next = head;
      this.head = newHead;
      size++;
      return true;
    }
    return false;

  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
    if (size < k) {

      DoubleListNode newtail = new DoubleListNode(value);
      tail.next = newtail;
      this.tail = newtail;
      size++;
      return true;
    }
    return false;
  }

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    this.head = head.next;
    size--;
    return true;

  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    this.tail = tail.pre;
    size--;
    return true;

  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
    return head.val;

  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    return tail.val;
  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    if (size == 0) return true;
    else return false;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    if (size == k) return true;
    else return false;

  }

  class DoubleListNode {
    DoubleListNode pre;
    DoubleListNode next;
    int val;

    public DoubleListNode(int val) {
      this.val = val;
    }
  }
}

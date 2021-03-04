package me.learn.dsa;

public class LinkedList {
  public ListNode reverse(ListNode head) {
    ListNode sourceTemp = head.next;

    head.next = sourceTemp.next;
    sourceTemp.next = head;

    return sourceTemp;
  }
}

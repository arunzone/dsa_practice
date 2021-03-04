package me.learn.dsa;

public class LinkedList {
  public ListNode reverse(ListNode head) {
    ListNode previous = null;
    while (head != null) {
      ListNode nextNode = head.next;
      head.next = previous;
      previous = head;
      head = nextNode;
    }
    return previous;
  }
}

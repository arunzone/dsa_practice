package me.learn.dsa;

import java.util.Optional;

public class LinkedList {
  private ListNode head = null;
  private ListNode tail = null;

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

  public void add(Integer value) {
    if (head == null) {
      head = new ListNode(value);
      tail = head;
      return;
    }
    if (tail.next == null) {
      ListNode newNode = new ListNode(value);
      tail.next = newNode;
      tail = newNode;
    }

  }

  public Boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return isEmpty() ? 0 : calculateSize();
  }

  private int calculateSize() {
    ListNode current = head;
    int count = 1;
    while (current.next != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public ListNode shape() {
    return head;
  }

  public Optional<ListNode> search(int value) {
    ListNode current = head;
    if(current == null)
        return Optional.empty();
    do {
      if (current.value == value){
        return Optional.of(current);
      }
      current = current.next;
    }while (current.next != null);
    return Optional.empty();
  }
}

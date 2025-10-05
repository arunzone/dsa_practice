package me.learn.dsa.linkedlist;

import java.util.Optional;

public class LinkedList {
  private ListNode head;
  private ListNode tail;

  public ListNode reverse(final ListNode head) {
    ListNode current = head;
    ListNode previous = null;
    while (current != null) {
      final ListNode nextNode = current.next;
      current.next = previous;
      previous = current;
      current = nextNode;
    }
    return previous;
  }

  public void add(final Integer value) {
    if (head == null) {
      head = new ListNode(value);
      tail = head;
      return;
    }
    if (tail.next == null) {
      final ListNode newNode = new ListNode(value);
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
    final ListNode current = head;
    int count = 1;
    ListNode node = current;
    while (node.next != null) {
      count++;
      node = node.next;
    }
    return count;
  }

  public ListNode shape() {
    return head;
  }

  public Optional<ListNode> search(final int value) {
    return head == null ? Optional.empty() : searchFromExisting(value);
  }

  private Optional<ListNode> searchFromExisting(final int value) {
    ListNode current = head;
    Optional<ListNode> result = Optional.empty();
    boolean found = false;
    while (current != null && !found) {
      if (current.getValue() == value) {
        result = Optional.of(current);
        found = true;
      } else {
        current = current.next;
      }
    }
    return result;
  }

  @Override
  public String toString() {
    String result = "";
    if (head != null) {
      final StringBuilder stringBuilder = new StringBuilder(50);
      ListNode current = head;

      // First node (Head)
      stringBuilder.append("[Head: ").append(current.getValue()).append(']');
      current = current.next;

      // Middle nodes
      while (current != null && !current.equals(tail)) {
        stringBuilder.append(" -> [").append(current.getValue()).append(']');
        current = current.next;
      }

      // Last node (Tail) if different from head
      if (tail != null && !tail.equals(head)) {
        stringBuilder.append(" -> [Tail: ").append(tail.getValue()).append(']');
      }

      result = stringBuilder.toString();
    }
    return result;
  }

  private void insertInBetween(final int value, final int index) {
    final NodePositionFinder.InsertPosition position =
        NodePositionFinder.findInsertPosition(head, index);
    if (position.isValid()) {
      final ListNode newNode = new ListNode(value);
      newNode.next = position.current();
      position.previous().next = newNode;
    }
  }

  public void insert(final int value, final int index) {
    if (index == 0) {
      head = new ListNode(value, head);
    } else {
      insertInBetween(value, index);
    }
  }
}

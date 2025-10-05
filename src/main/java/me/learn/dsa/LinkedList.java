package me.learn.dsa;

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

  public void insert(final int value, final int index) {
    final InsertPosition position = findInsertPosition(index);

    if (position.isValid()) {
      final ListNode newNode = new ListNode(value);
      newNode.next = position.current;
      position.previous.next = newNode;
    }
  }

  private InsertPosition findInsertPosition(final int targetIndex) {
    ListNode current = head;
    ListNode previous = null;
    int currentIndex = 0;

    while (current != null && currentIndex < targetIndex) {
      previous = current;
      current = current.next;
      currentIndex++;
    }

    return new InsertPosition(current, previous, currentIndex, targetIndex);
  }

  private static class InsertPosition {
    final ListNode current;
    final ListNode previous;
    final int reachedIndex;
    final int targetIndex;

    InsertPosition(
        final ListNode current,
        final ListNode previous,
        final int reachedIndex,
        final int targetIndex) {
      this.current = current;
      this.previous = previous;
      this.reachedIndex = reachedIndex;
      this.targetIndex = targetIndex;
    }

    boolean isValid() {
      return reachedIndex == targetIndex && previous != null && current != null;
    }
  }
}

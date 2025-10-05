package me.learn.dsa.linkedlist;

final class NodePositionFinder {
  private NodePositionFinder() {}

  static InsertPosition findInsertPosition(final ListNode head, final int targetIndex) {
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

  record InsertPosition(ListNode current, ListNode previous, int reachedIndex, int targetIndex) {
    boolean isValid() {
      return reachedIndex == targetIndex && previous != null && current != null;
    }
  }
}

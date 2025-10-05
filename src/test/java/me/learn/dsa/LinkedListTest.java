package me.learn.dsa;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAndIs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class LinkedListTest {
  @Test
  void shouldReverseTwoNodes() {
    final LinkedList linkedList = new LinkedList();
    final ListNode head = new ListNode(1, new ListNode(2));
    final ListNode reversed = linkedList.reverse(head);

    assertThat(reversed, is(new ListNode(2, new ListNode(1))));
  }

  @Test
  void shouldReverseMoreNodes() {
    final LinkedList linkedList = new LinkedList();
    final ListNode head =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    final ListNode reversed = linkedList.reverse(head);

    assertThat(
        reversed,
        is(new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
  }

  @Test
  void shouldReturnTrueForIsEmpty() {
    final LinkedList linkedList = new LinkedList();
    final Boolean empty = linkedList.isEmpty();

    assertThat(empty, is(true));
  }

  @Test
  void shouldReturnSize() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(2);
    linkedList.add(4);

    assertThat(linkedList.size(), is(3));
  }

  @Test
  void shouldReturnEmptySizeZero() {
    final LinkedList linkedList = new LinkedList();

    assertThat(linkedList.size(), is(0));
  }

  @Test
  void shouldReturnMatchingNode() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(2);

    final Optional<ListNode> node = linkedList.search(2);
    assertThat(node, isPresentAndIs(new ListNode(2)));
  }

  @Test
  void shouldReturnNullWhenNoMatchingFound() {
    final LinkedList linkedList = new LinkedList();

    final Optional<ListNode> node = linkedList.search(2);
    assertThat(node, isEmpty());
  }
}

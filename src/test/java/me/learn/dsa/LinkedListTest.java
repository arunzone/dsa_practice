package me.learn.dsa;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.github.npathai.hamcrestopt.OptionalMatchers.isEmpty;
import static com.github.npathai.hamcrestopt.OptionalMatchers.isPresentAndIs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

class LinkedListTest {
  @Test
  void shouldReverseTwoNodes() {
    LinkedList linkedList = new LinkedList();
    ListNode head = new ListNode(1, new ListNode(2));
    ListNode reversed = linkedList.reverse(head);

    assertThat(reversed, is(new ListNode(2, new ListNode(1))));
  }

  @Test
  void shouldReverseMoreNodes() {
    LinkedList linkedList = new LinkedList();
    ListNode head = new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode reversed = linkedList.reverse(head);

    assertThat(reversed, is(new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
  }

  @Test
  void shouldAddFirstNewNode() {
    LinkedList linkedList = new LinkedList();
    linkedList.add(5);

    assertThat(linkedList.shape(), is(new ListNode(5)));
  }

  @Test
  void shouldAddSecondNode() {
    LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(2);

    assertThat(linkedList.shape(), is(new ListNode(5, new ListNode(2))));
  }

  @Test
  void shouldAddThirdNode() {
    LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(2);
    linkedList.add(4);

    assertThat(linkedList.shape(), is(new ListNode(5, new ListNode(2, new ListNode(4)))));
  }

  @Test
  void shouldReturnTrueForIsEmpty() {
    LinkedList linkedList = new LinkedList();
    var empty = linkedList.isEmpty();

    assertThat(empty, is(true));
  }

  @Test
  void shouldReturnSize() {
    LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(2);
    linkedList.add(4);

    assertThat(linkedList.size(), is(3));
  }

  @Test
  void shouldReturnEmptySizeZero() {
    LinkedList linkedList = new LinkedList();

    assertThat(linkedList.size(), is(0));
  }

  @Test
  void shouldReturnMatchingNode(){
    LinkedList linkedList = new LinkedList();
    linkedList.add(2);

    Optional<ListNode> node = linkedList.search(2);
    assertThat(node, isPresentAndIs(new ListNode(2)));
  }

  @Test
  void shouldReturnNullWhenNoMatchingFound(){
    LinkedList linkedList = new LinkedList();

    Optional<ListNode> node = linkedList.search(2);
    assertThat(node, isEmpty());
  }

}
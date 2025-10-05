package me.learn.dsa.linkedlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class LinkedListAddTest {
  @Test
  void shouldAddFirstNewNode() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(5);

    assertThat(linkedList.shape(), is(new ListNode(5)));
  }

  @Test
  void shouldAddSecondNode() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(2);

    assertThat(linkedList.shape(), is(new ListNode(5, new ListNode(2))));
  }

  @Test
  void shouldAddThirdNode() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(5);
    linkedList.add(2);
    linkedList.add(4);

    assertThat(linkedList.shape(), is(new ListNode(5, new ListNode(2, new ListNode(4)))));
  }
}

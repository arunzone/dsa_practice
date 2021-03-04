package me.learn.dsa;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class LinkedListTest {
  @Test
  void shouldReverseTwoNodes() {
    LinkedList linkedList = new LinkedList();
    ListNode head = new ListNode(1, new ListNode(2));
    ListNode reversed = linkedList.reverse(head);

    assertThat(reversed, is(new ListNode(2, new ListNode(1))));
  }

  
}
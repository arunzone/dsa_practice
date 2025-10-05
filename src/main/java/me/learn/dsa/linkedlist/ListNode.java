package me.learn.dsa.linkedlist;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class ListNode {
  @Getter private final int value;
  ListNode next;

  ListNode(final int val) {
    this.value = val;
  }

  ListNode(final int val, final ListNode next) {
    this.value = val;
    this.next = next;
  }
}

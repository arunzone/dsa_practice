package me.learn.dsa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

@EqualsAndHashCode
public class ListNode {
  @Getter private final int value;
  @Accessors ListNode next;

  ListNode(final int val) {
    this.value = val;
  }

  ListNode(final int val, final ListNode next) {
    this.value = val;
    this.next = next;
  }
}

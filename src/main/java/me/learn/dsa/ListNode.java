package me.learn.dsa;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ListNode {
  int value;
  ListNode next;

  ListNode(int val) {
    this.value = val;
  }

  ListNode(int val, ListNode next) {
    this.value = val;
    this.next = next;
  }
}

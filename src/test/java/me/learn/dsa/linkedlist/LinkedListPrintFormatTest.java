package me.learn.dsa.linkedlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class LinkedListPrintFormatTest {

  @Test
  void shouldReturnEmptyStringForEmptyList() {
    final LinkedList linkedList = new LinkedList();

    assertThat(linkedList.toString(), is(""));
  }

  @Test
  void shouldReturnFormattedStringForSingleNode() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(3);

    assertThat(linkedList.toString(), is("[Head: 3]"));
  }

  @Test
  void shouldReturnFormattedStringForMultipleNodes() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(3);
    linkedList.add(2);
    linkedList.add(1);

    assertThat(linkedList.toString(), is("[Head: 3] -> [2] -> [Tail: 1]"));
  }

  @Test
  void shouldInsertDataInGivenIndex() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(1);
    linkedList.add(2);

    linkedList.insert(5, 1);

    assertThat(linkedList.toString(), is("[Head: 1] -> [5] -> [Tail: 2]"));
  }
}

package me.learn.dsa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

class LinkedListInsertTest {
  @Test
  void shouldInsertDataInGivenIndex() {
    final LinkedList linkedList = new LinkedList();
    linkedList.add(1);
    linkedList.add(2);

    linkedList.insert(5, 1);

    assertThat(linkedList.toString(), is("[Head: 1] -> [5] -> [Tail: 2]"));
  }
}

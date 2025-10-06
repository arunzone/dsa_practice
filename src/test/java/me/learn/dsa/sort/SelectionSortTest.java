package me.learn.dsa.sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.List;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
  @Test
  void shouldReturnSortedList() {
    var sortedList = new SelectionSort().sort(List.of(6, 1, 9, 5));

    assertThat(sortedList, contains(1, 5, 6, 9));
  }
}

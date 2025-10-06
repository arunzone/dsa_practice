package me.learn.dsa.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

class QuickSortTest {

  @Test
  void shouldReturnSortedItems() {
    var result = new QuickSort().sort(List.of(6, 2, 9, 4, 8, 1, 5));

    assertThat(result, contains(1, 2, 4, 5, 6, 8, 9));
  }

}
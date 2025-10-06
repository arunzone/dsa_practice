package me.learn.dsa.sort;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.List;
import org.junit.jupiter.api.Test;

class MergeSortTest {
  @Test
  void shouldReturnEmptyListAsIs() {
    var result = new MergeSort().sort(List.of());

    assertThat(result, is(emptyList()));
  }

  @Test
  void shouldReturnSingleItemListAsIs() {
    var result = new MergeSort().sort(List.of(1));

    assertThat(result, contains(1));
  }

  @Test
  void shouldReturnSortedItemForFourHighestToLowestUnsortedList() {
    var result = new MergeSort().sort(List.of(8, 5, 2, 1));

    assertThat(result, contains(1, 2, 5, 8));
  }

  @Test
  void shouldReturnSortedItemForFourPartialUnsortedList() {
    var result = new MergeSort().sort(List.of(8, 2, 5, 1));

    assertThat(result, contains(1, 2, 5, 8));
  }

  @Test
  void shouldReturnSortedItemForOddSizedUnsortedList() {
    var result = new MergeSort().sort(List.of(8, 2, 10, 5, 1));

    assertThat(result, contains(1, 2, 5, 8, 10));
  }
}

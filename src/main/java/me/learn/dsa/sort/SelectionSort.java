package me.learn.dsa.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
  public List<Integer> sort(List<Integer> input) {
    var givenInput = new ArrayList<>(input);
    final List<Integer> result = new ArrayList<>();
    for (int index = 0; index < input.size(); index++) {
      var indexToMove = findMinimumIndex(givenInput);
      result.add(givenInput.remove(indexToMove));
    }
    return result;
  }

  private int findMinimumIndex(List<Integer> input) {
    int minimumIndex = 0;
    for (int unprocessedIndex = 0; unprocessedIndex < input.size(); unprocessedIndex++) {
      if (input.get(unprocessedIndex) < input.get(minimumIndex)) {
        minimumIndex = unprocessedIndex;
      }
    }
    return minimumIndex;
  }
}

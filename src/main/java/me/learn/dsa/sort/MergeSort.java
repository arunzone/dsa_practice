package me.learn.dsa.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
  public List<Integer> sort(List<Integer> input) {
    if (input.size() <= 1) {
      return input;
    }
    int half = Math.floorDiv(input.size(), 2);
    List<Integer> leftHalf = input.subList(0, half);
    List<Integer> rightHalf = input.subList(half, input.size());
    var left = sort(leftHalf);
    var right = sort(rightHalf);
    return merge(left, right);
  }

  private List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> merged = new ArrayList<>();
    int rightPosition = 0;
    int leftPosition = 0;
    int leftLength = left.size();
    int rightLength = right.size();
    while (leftPosition < leftLength && rightPosition < rightLength) {
      if (left.get(leftPosition) < right.get(rightPosition)) {
        merged.add(left.get(leftPosition));
        leftPosition++;
      } else {
        merged.add(right.get(rightPosition));
        rightPosition++;
      }
    }
    while (leftPosition < leftLength) {
      merged.add(left.get(leftPosition));
      leftPosition++;
    }
    while (rightPosition < rightLength) {
      merged.add(right.get(rightPosition));
      rightPosition++;
    }

    return merged;
  }
}

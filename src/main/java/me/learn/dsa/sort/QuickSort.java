package me.learn.dsa.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
  public List<Integer> sort(List<Integer> input) {
    if(input.size()<=1){
      return input;
    }
    var lessThanPivot = new ArrayList<Integer>();
    var greaterThanPivot = new ArrayList<Integer>();
    Integer pivot = input.getFirst();
    for (var value: input.subList(1, input.size())) {
      if (value <= pivot){
        lessThanPivot.add(value);
      }else {
        greaterThanPivot.add(value);
      }
    }
    System.out.printf("%s %d %s%n", lessThanPivot, pivot, greaterThanPivot);
    return Stream.of(sort(lessThanPivot), List.of(pivot), sort(greaterThanPivot)).flatMap(List::stream).collect(Collectors.toList());
  }
}

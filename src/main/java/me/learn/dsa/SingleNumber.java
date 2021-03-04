package me.learn.dsa;

public class SingleNumber {
  public Integer singleFrom(Integer[] elements) {
    Integer unpaired = elements[0];
    for (int i = 1; i < elements.length; i++) {
      unpaired ^= elements[i];
    }
    return unpaired;
  }
}

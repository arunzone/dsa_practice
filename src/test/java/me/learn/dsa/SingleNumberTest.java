package me.learn.dsa;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SingleNumberTest {
  @Test
  void shouldReturnSingleNumber() {
    SingleNumber singleNumber = new SingleNumber();
    Integer single = singleNumber.singleFrom(new Integer[]{2, 2, 1});

    assertThat(single, is(1));
  }
}
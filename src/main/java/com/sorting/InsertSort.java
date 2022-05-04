package com.sorting;

import java.time.Duration;
import java.time.LocalTime;

public class InsertSort implements SortingAlgorithm {
  @Override
  public long sort(int numberOfNumbersToSort, int[] tab) {
    LocalTime startTime = LocalTime.now();

    for (int i = 1; i < numberOfNumbersToSort; i++) {
      int numberToInsert = tab[i - 1];
      int j = i - 1;
      while (j > 0 && tab[j] > numberToInsert) {
        tab[j + 1] = tab[j];
        j--;
      }
      tab[j] = numberToInsert;
    }
    LocalTime endTime = LocalTime.now();

    return Duration.between(startTime, endTime).getSeconds();
  }
}

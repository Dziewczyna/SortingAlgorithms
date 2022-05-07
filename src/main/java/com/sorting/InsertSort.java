package com.sorting;

public class InsertSort implements SortingAlgorithm {
  @Override
  public long sort(int numberOfNumbersToSort, int[] tab) {
    long startTime = System.nanoTime();

    for (int i = 1; i < numberOfNumbersToSort; i++) {
      int numberToInsert = tab[i - 1];
      int j = i - 1;
      while (j > 0 && tab[j] > numberToInsert) {
        tab[j + 1] = tab[j];
        j--;
      }
      tab[j] = numberToInsert;
    }
    long endTime = System.nanoTime();

    return endTime - startTime;
  }
}

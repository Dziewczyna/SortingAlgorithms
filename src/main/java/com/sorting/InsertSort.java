package com.sorting;

public class InsertSort implements SortingAlgorithm {
  @Override
  public int[] sort(int numberOfNumbersToSort, int[] tab) {
    for (int i = 1; i < numberOfNumbersToSort; i++) {
      int numberToInsert = tab[i - 1];
      int j = i - 1;
      while (j > 0 && tab[j] > numberToInsert) {
        tab[j + 1] = tab[j];
        j--;
      }
      tab[j] = numberToInsert;
    }

    System.out.println("Sorted by Insert sort");
    return tab;
  }
}

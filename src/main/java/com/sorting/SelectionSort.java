package com.sorting;

public class SelectionSort implements SortingAlgorithm {

  @Override
  public long sort(int[] tab) {
    long startTime = System.nanoTime();

    for (int i = 0; i < tab.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < tab.length; j++) {
        if (tab[j] < tab[minIndex]) minIndex = j;
      }
      int temp = tab[i];
      tab[i] = tab[minIndex];
      tab[minIndex] = temp;
    }
    long endTime = System.nanoTime();

    return endTime - startTime;
  }
}

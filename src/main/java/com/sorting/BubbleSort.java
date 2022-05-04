package com.sorting;

public class BubbleSort implements SortingAlgorithm {

  public long sort(int numberOfNumbers, int[] tab) {
    int originalNumberOfNumbers = numberOfNumbers;

    long startTime = System.currentTimeMillis();
    System.out.println("s:" + startTime);
    do {
      for (int i = 0; i < numberOfNumbers - 1; i++) {
        if (tab[i] > tab[i + 1]) {
          int temp = tab[i];
          tab[i] = tab[i + 1];
          tab[i + 1] = temp;
        }
      }
      numberOfNumbers = numberOfNumbers - 1;
    } while (numberOfNumbers > 1);
    long endTime = System.currentTimeMillis();
    System.out.println("e:" + endTime);

    return endTime - startTime;
  }
}

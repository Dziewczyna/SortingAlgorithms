package com.sorting;

public class MergeSort implements SortingAlgorithm {
  int[] tmp;

  @Override
  public long sort(int[] tab) {
    long leftTime = System.nanoTime();
    mergeSort(tab, 0, tab.length - 1);

    long rightTime = System.nanoTime();

    return rightTime - leftTime;
  }

  private void mergeSort(int[] tab, int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;
      mergeSort(tab, left, middle);
      mergeSort(tab, middle + 1, right);
      mergeTabs(tab, left, middle, right);
    }
  }

  private void mergeTabs(int[] tab, int left, int middle, int right) {
    int i = 0, first = left, last = middle + 1;
    int[] tmp = new int[right - left + 1];

    while (first <= middle && last <= right) {
      tmp[i++] = tab[first] < tab[last] ? tab[first++] : tab[last++];
    }
    while (first <= middle) {
      tmp[i++] = tab[first++];
    }
    while (last <= right) {
      tmp[i++] = tab[last++];
    }
    i = 0;
    while (left <= right) {
      tab[left++] = tmp[i++];
    }
  }
}

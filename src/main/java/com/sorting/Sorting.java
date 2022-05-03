package com.sorting;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Sorting {
  public static void main(String[] args) {
    int numberOfNumbers = readNumberOfInts();
    int[] numbersToSort = readNumbers(numberOfNumbers);

    BubbleSort bubbleSort = new BubbleSort();
    InsertSort insertSort = new InsertSort();

    List<SortingAlgorithm> sortingAlgorithms = new ArrayList<>();
    sortingAlgorithms.add(bubbleSort);
    sortingAlgorithms.add(insertSort);

    for (SortingAlgorithm sortingAlgorithm : sortingAlgorithms) {
      printSortedTab(numberOfNumbers, sortingAlgorithm.sort(numberOfNumbers, numbersToSort));
    }
  }

  private static int readNumberOfInts() {
    int numberOfNumbers = 0;

    Scanner scan = new Scanner(System.in);
    try {
      System.out.print("What's the number of numbers? ");
      String numberofNumbersToConvert = scan.nextLine();
      numberOfNumbers = Integer.parseInt(numberofNumbersToConvert);
    } catch (NumberFormatException ex) {
      System.out.println("Not a number!");
      System.exit(0);
    }

    return numberOfNumbers;
  }

  private static int[] readNumbers(int numberOfNumbers) {
    int[] numbers;

    Scanner scan = new Scanner(System.in);

    numbers = new int[numberOfNumbers];
    try {
      for (int i = 1; i <= numberOfNumbers; i++) {
        System.out.println("Give " + i + " number: ");
        numbers[i - 1] = scan.nextInt();
      }
    } catch (InputMismatchException e) {
      System.out.println("Wrong format!");
    }

    return numbers;
  }

  private static void printSortedTab(int numberOfNumbers, int[] sortedTab) {
    for (int i = 0; i < numberOfNumbers; i++) {
      System.out.print(sortedTab[i] + " ");
    }
    System.out.println("\n");
  }
}

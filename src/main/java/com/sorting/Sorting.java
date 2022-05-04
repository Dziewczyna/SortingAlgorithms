package com.sorting;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Sorting {
  public static void main(String[] args) {
    System.out.println("            |     10    |    100    |    1000    |    10_000    |");
    System.out.println("\n");
    System.out.printf(
        "BubbleSort  |    %d     |    %d    |    %d    |    %d    |",
        elapsedTime("bubble", 10),
        elapsedTime("bubble", 100),
        elapsedTime("bubble", 1000),
        elapsedTime("bubble", 10_000));
    System.out.println("\n");
    System.out.printf(
        "InsertSort  |    %d     |    %d    |    %d    |    %d    |",
        elapsedTime("insert", 10),
        elapsedTime("insert", 100),
        elapsedTime("insert", 1000),
        elapsedTime("insert", 10_000));
    System.out.println("\n");
    System.out.printf(
        "SelectSort  |    %d     |    %d    |    %d    |    %d    |",
        elapsedTime("select", 10),
        elapsedTime("select", 100),
        elapsedTime("select", 1000),
        elapsedTime("select", 10_000));
  }

  private static long elapsedTime(String algorithm, int numberOfInts) {
    BubbleSort bubbleSort = new BubbleSort();
    InsertSort insertSort = new InsertSort();
    SelectionSort selectSort = new SelectionSort();
    int[] numbersToSort = generateRandomInts(numberOfInts);
    return switch (algorithm) {
      case "bubble" -> bubbleSort.sort(numberOfInts, numbersToSort);
      case "insert" -> insertSort.sort(numberOfInts, numbersToSort);
      case "select" -> selectSort.sort(numberOfInts, numbersToSort);
      default -> 0;
    };
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

  private static int pickNumberOfInts() {
    int selectedNumberOfNumbers = 0;

    Scanner scan = new Scanner(System.in);
    try {
      System.out.println("Pick amount of numbers: ");
      System.out.println("1 - 10 numbers");
      System.out.println("2 - 100 numbers");
      System.out.println("3 - 1000 numbers");
      System.out.println("4 - 10_000 numbers");
      String numberofNumbersToConvert = scan.nextLine();
      selectedNumberOfNumbers = Integer.parseInt(numberofNumbersToConvert);
      switch (selectedNumberOfNumbers) {
        case 1 -> selectedNumberOfNumbers = 10;
        case 2 -> selectedNumberOfNumbers = 100;
        case 3 -> selectedNumberOfNumbers = 1000;
        case 4 -> selectedNumberOfNumbers = 10_000;
        default -> {
          selectedNumberOfNumbers = 0;
          System.out.println("Wrong choice!");
        }
      }
    } catch (NumberFormatException ex) {
      System.out.println("Wrong number!");
      System.exit(0);
    }

    return selectedNumberOfNumbers;
  }

  private static int[] generateRandomInts(int amountOfNumbers) {
    int[] generatedArr;
    switch (amountOfNumbers) {
      case 10 -> generatedArr = generateArrayOfNumbers(10);
      case 100 -> generatedArr = generateArrayOfNumbers(100);
      case 1000 -> generatedArr = generateArrayOfNumbers(1000);
      case 10_000 -> generatedArr = generateArrayOfNumbers(10_000);
      default -> {
        generatedArr = new int[0];
        System.out.println("Wrong choice!");
      }
    }

    return generatedArr;
  }

  private static int[] generateArrayOfNumbers(int amountOfInts) {
    Random rd = new Random();
    int[] arr = new int[amountOfInts];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = rd.nextInt();
    }
    return arr;
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

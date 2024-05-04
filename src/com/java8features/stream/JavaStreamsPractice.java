package com.java8features.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreamsPractice {

    public static void main(String[] args) {
//        // 1. Separate odd & even integers
//        System.out.println("1. Separate odd & even integers");
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println(separateOddEvenIntegers(numbers));
//        System.out.println("***********************************************");
//
//        // 2. Frequency of each character in a string
//        System.out.println("2. Frequency of each character in a string");
//        String str = "geeksforgeeks";
//        System.out.println(getFrequencyOfEachCharacter(str));
//        System.out.println("***********************************************");
//
//        // 3. Sort the list in reverse order
//        System.out.println("3. Sort the list in reverse order");
//        List<Integer> listOfNumbers = Arrays.asList(4, 7, 3, 10, 16, 18, 11, 13, 9, 8, 19);
//        System.out.println("Original List: " + listOfNumbers);
//        System.out.println("Reversed List: " + sortListInReverseOrder(listOfNumbers));
//        System.out.println("********************************************");

//        // 4. Merge two unsorted array into a single sorted array
//        System.out.println("4. Merge two unsorted array into a single sorted array");
//        int[] a = {4, 7, 3,7, 19,10, 16, 18};
//        int[] b = {11, 13, 9, 8, 19};
//        System.out.println("Original Array 1: " + Arrays.toString(a));
//        System.out.println("Original Array 2: " + Arrays.toString(b));
//        System.out.println("Merged Array: "
//                + Arrays.toString(mergeTwoUnsortedArraysInSingleSortedArray(a, b)));
//        System.out.println("**********************************************************");
//
//        // 5. Merge two unsorted array into a single sorted array without duplicates
//        System.out.println("5. Merge two unsorted array into a single sorted array");
//        int[] one = {4, 7, 3,7, 19,10, 16, 18};
//        int[] two = {11, 13, 9, 8, 19};
//        System.out.println("Original Array 1: " + Arrays.toString(one));
//        System.out.println("Original Array 2: " + Arrays.toString(two));
//        System.out.println("Merged Array: "
//                + Arrays.toString(
//                        mergeTwoUnsortedArraysInSingleSortedArrayWithoutDuplicates(one, two)));
//        System.out.println("**********************************************************");

//        // 6. Three max and min numbers from a list
//        System.out.println("6. Three max and min numbers from a list");
//        List<Integer> listOfNumbers = Arrays.asList(4, 7, 3, 10, 16, 18, 11, 13, 9, 8, 19);
//        System.out.println("Original List: " + listOfNumbers);
//        threeMaxAndMinNumbersFromList(listOfNumbers);
//        System.out.println("********************************************");

//        // 7. Sort list of strings in increasing order of their lengths
//        System.out.println("7. Sort list of strings in increasing order of their lengths");
//        List<String> listOfStrings = Arrays.asList("Sum", "max", "science", "super", "power", "health", "three");
//        System.out.println("Original List: " + listOfStrings);
//        System.out.println("Sorted List: " + sortListOfStringsByLengths(listOfStrings));
//        System.out.println("********************************************");

//        // 8. Sum and average of all elements of array
//        System.out.println("// 8. Sum and average of all elements of array");
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        System.out.println("Original Array: " + Arrays.toString(array));
//        sumAndAverageOfArray(array);
//        System.out.println("********************************************");

//        // 9. Reverse an integer array
//        System.out.println("// 9. Reverse an integer array");
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        System.out.println("Original Array: " + Arrays.toString(array));
//        System.out.println("Reversed Array: " + Arrays.toString(reverseIntegerArray(array)));
//        System.out.println("********************************************");

        // 10. Palindrome program in Java 8
        System.out.println("// 10. Palindrome program in Java 8");
        String str = "racecar";
        System.out.println("Original String: " + str);
        System.out.println("Is Palindrome: " + palindromeValidate(str));
        System.out.println("********************************************");
    }

    // 1. Separate odd & even integers
    private static Map<Boolean, List<Integer>> separateOddEvenIntegers(List<Integer> numbers) {
         return numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
    }

    // 2. Frequency of each character in a string
    private static Map<Character, Long> getFrequencyOfEachCharacter(String str) {
        return str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

    }

    // 3. Sort the list in reverse order
    private static List<Integer> sortListInReverseOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // 4. Merge two unsorted array into a single sorted array
    private static int[] mergeTwoUnsortedArraysInSingleSortedArray(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .sorted()
                .toArray();
    }

    // 5. Merge two unsorted array into a single sorted array without duplicates
    private static int[]
    mergeTwoUnsortedArraysInSingleSortedArrayWithoutDuplicates(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .sorted()
                .distinct()
                .toArray();
    }

    // 6. Three max and min numbers from a list
    private static void threeMaxAndMinNumbersFromList(List<Integer> numbers) {
        System.out.println("Three max numbers : ");
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
        System.out.println("Three min numbers : ");
        numbers.stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }

    // 7. Sort list of strings in increasing order of their lengths
    private static List<String> sortListOfStringsByLengths(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    // 8. Sum and average of all elements of array
    private static void sumAndAverageOfArray(int[] numbers) {
        System.out.println("Sum : " + Arrays.stream(numbers)
                .sum());

        System.out.println("Average: " + Arrays.stream(numbers)
                .average().getAsDouble());
    }

    // 9. Reverse an integer array
    private static int[] reverseIntegerArray(int[] numbers) {
        return IntStream.rangeClosed(0, numbers.length - 1)
                .map(i -> numbers[numbers.length - i - 1])
                .toArray();
    }

    // 10. Palindrome program in Java 8
    private static boolean palindromeValidate(String str) {
        return IntStream.rangeClosed(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
    }
}

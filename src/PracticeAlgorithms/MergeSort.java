package PracticeAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] arr = {12, 24, 13, 123, 123, 123, 3, 11, 3312, 323, 123, 11, 2312, 37};

        mergesort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergesort(Comparable[] arr, int start, int end) {
        if (end - start > 1) {
            int mid = (end-start)/2 + start;

            mergesort(arr, start, mid);
            mergesort(arr, mid, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(Comparable[] arr, int start, int mid, int end) {
        Comparable[] left = Arrays.copyOfRange(arr, start, mid);
        Comparable[] right = Arrays.copyOfRange(arr, mid, end);

        int lpointer = 0;
        int rpointer = 0;


        int i = 0;
        while (lpointer < left.length && rpointer < right.length) {
            if (left[lpointer].compareTo(right[rpointer]) < 0 && lpointer < left.length) {
                arr[i + start] = left[lpointer++];
            } else {
                arr[i + start] = right[rpointer++];
            }
            i++;
        }

        if (lpointer < left.length) {
            for (int j = i; j < end - start; j++) arr[j + start] = left[lpointer];
        } else if (rpointer < right.length) {
            for (int j = i; j < end - start; j++) arr[j + start] = right[rpointer];
        }
    }
}

package PracticeAlgorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = {12, 24, 13, 123, 123, 123, 3, 11, 3312, 323, 123, 11, 2312, 37};

        quicksort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void quicksort(Comparable[] arr, int start, int end) {
        if (end - start > 1) {
            int p = partition(arr, start, end);
            quicksort(arr, start, p);
            quicksort(arr, p+1, end);
        }
    }

    public static int partition(Comparable[] arr, int start, int end) {
        Comparable pivot = arr[end-1];
        int beforePivot = start - 1;
        for(int i = start; i < end; i++) if (arr[i].compareTo(pivot) < 0) swap(arr, i, ++beforePivot);
        swap(arr, end-1, ++beforePivot);
        return beforePivot;
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

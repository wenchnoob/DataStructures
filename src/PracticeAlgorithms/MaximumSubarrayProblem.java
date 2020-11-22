package PracticeAlgorithms;

public class MaximumSubarrayProblem {
    public static void main(String[] args) {

    }

    public static Integer[] largestSubArray(Integer[] arr, int start, int end) {
        if (end - start >= 1) {
            int mid = (end - start)/2 + start;
            largestSubArray(arr, start, mid);
            largestSubArray(arr, mid, end);

        }

        return arr;
    }

    public static int sum(Integer[] arr) {
        int sum = 0;
        for (int num: arr) sum += num;
        return sum;
    }
}

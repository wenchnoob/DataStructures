package PracticeAlgorithms;

import java.util.Arrays;

public class EscapePods {

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{0,1}, new int[]{4,5}, new int[][]{
                new int[]{0,0,4,6,0,0},
                new int[]{0,0,5,2,0,0},
                new int[]{0,0,0,0,4,4},
                new int[]{0,0,0,0,6,6},
                new int[]{0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0}
        } ));

        System.out.println(Solution.solution(new int[]{0}, new int[]{3}, new int[][]{
                new int[]{0,7,0,0},
                new int[]{0,0,6,0},
                new int[]{0,0,0,8},
                new int[]{9,0,0,0}
        } ));
    }

    private static class Solution {
        public static int solution(int[] entrances, int[] exits, int[][] path) {
            int[][] minPath = map(path, entrances.length, exits.length);
            int[] bunniesRoom = new int[minPath.length + exits.length];

            for(int i = 0; i < minPath.length; i++) {
                for (int j = 0; j < minPath[i].length; j++) {
                    if (i >= entrances.length) {
                        move(bunniesRoom, i-exits.length, j+ exits.length, minPath[i][j]);
                    } else {
                        bunniesRoom[j] += minPath[i][j];
                    }
                }
            }
            return Arrays.stream(Arrays.copyOfRange(bunniesRoom, minPath.length-exits.length, bunniesRoom.length)).sum();
        }

        static void move(int[] arr, int from, int to, int max) {
            if (max == 0) return;

            if (arr[from] > max) {
                arr[from] = arr[from] - max;
                arr[to] = arr[to] + max;
            } else {
                arr[to] = arr[to] + arr[from];
                arr[from] = 0;
            }
        }

        static int[][] map(int[][] path, int entranceSize, int exitSize) {
            for (int i = 0; i < path.length; i++) path[i] = Arrays.copyOfRange(path[i], entranceSize, path.length);
            return Arrays.copyOfRange(path, 0, path.length - exitSize);
        }
    }

}


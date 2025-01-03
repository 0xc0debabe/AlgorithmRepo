
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(10, new int[]{1, 10, 2, 5, 6, 7, 8});
    }

    public int[] solution(int k, int[] score) {
        int[] arr = new int[2001];

        List<Integer> list = new ArrayList<>();
        Arrays.fill(arr, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < Math.min(k, score.length); i++) {
            arr[i] = score[i];
            min = Math.min(min, arr[i]);
            list.add(min);
        }

        for (int i = k - 1; i < score.length - 1; i++) {
            arr[i + 1] = score[i + 1];
            Arrays.sort(arr);
            list.add(arr[i + 1 - k + 1]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


}

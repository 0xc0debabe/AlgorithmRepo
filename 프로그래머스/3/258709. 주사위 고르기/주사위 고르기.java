import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dice = {
                {1, 2, 3, 4, 5, 6},
                {3, 3, 3, 3, 4, 4},
                {1, 3, 3, 4, 4, 4},
                {1, 1, 4, 4, 5, 5}
        };
        int[] solution1 = solution.solution(dice);
    }

    int[][] dices;
    public int[] solution(int[][] dice) {
        dices = dice;
        int len = dice.length;
        List<int[]> diceIdxCombList = new ArrayList<>();
        combination(len, 0, diceIdxCombList, new int[len / 2], 0);
        int[] answer = new int[len / 2];
        int max = 0;

        for (int[] aDiceIdx : diceIdxCombList) {
            boolean[] restIdx = new boolean[len];
            int[] bDiceIdx = new int[len / 2];
            int idx = 0;
            for (int i = 0; i < len / 2; i++) restIdx[aDiceIdx[i]] = true;
            for (int i = 0; i < len; i++) if (!restIdx[i]) bDiceIdx[idx++] = i;

            List<Integer> aSumList = new ArrayList<>();
            List<Integer> bSumList = new ArrayList<>();

            calculateSum(aDiceIdx, 0, aDiceIdx.length, 0, aSumList);
            calculateSum(bDiceIdx, 0, aDiceIdx.length, 0, bSumList);

            Collections.sort(bSumList);

            int totalWinCount = 0;
            for (int a : aSumList) {
                int winCount = lowerBinarySearch(0, bSumList.size() - 1, a, bSumList);
                totalWinCount += winCount;
            }

            if (max < totalWinCount) {
                max = totalWinCount;

                for (int i = 0; i < aDiceIdx.length; i++) {
                    answer[i] = aDiceIdx[i] + 1;
                }
            }
        }

        return answer;
    }

    private int lowerBinarySearch(int left, int right, int target, List<Integer> list) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private void calculateSum(int[] diceIdx, int depth, int n, int sum, List<Integer> list) {
        if (depth == n) {
            list.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            calculateSum(diceIdx, depth + 1, n, sum + dices[diceIdx[depth]][i], list);
        }
    }

    private void combination(int len, int depth, List<int[]> diceCombList, int[] arr, int k) {
        if (len / 2 == depth) {
            diceCombList.add(arr.clone());
            return;
        }

        for (int i = k; i < len; i++) {
            arr[depth] = i;
            combination(len, depth + 1, diceCombList, arr, i + 1);
        }
    }

}
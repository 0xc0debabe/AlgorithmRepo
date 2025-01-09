import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 3};
        int[] arr2 = {3,4};
        System.out.println(sol.solution(5, arr, arr2));
    }


    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] lostStudent = new boolean[n + 1];
        boolean[] reserveStudent = new boolean[n + 1];
        for (int l : lost) lostStudent[l] = true;
        for (int r : reserve) reserveStudent[r] = true;

        for (int i = 1; i < n + 1; i++) {
            if (lostStudent[i] && reserveStudent[i]) {
                lostStudent[i] = false;
                reserveStudent[i] = false;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (lostStudent[i]) {

                if (i > 1 && reserveStudent[i - 1]) {
                    lostStudent[i] = false;
                    reserveStudent[i - 1] = false;
                } else if (i < n && reserveStudent[i + 1]) {
                    lostStudent[i] = false;
                    reserveStudent[i + 1] = false;
                }

            }
        }

        int answer = 0;
        for (int i = 1; i < lostStudent.length; i++) {
            if (!lostStudent[i]) answer++;
        }

        return answer;
    }

}

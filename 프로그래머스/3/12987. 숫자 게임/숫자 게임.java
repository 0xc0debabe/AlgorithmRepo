import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        solution.solution(a, b);
    }

    public int solution(int[] A, int[] B) {
        List<Integer> list = new ArrayList<>();
        for (int i : B) list.add(i);
        Collections.sort(list);
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            int target = A[i];

            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (target >= list.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left < list.size() && list.get(left) > target) {
                answer++;
            }

            if (left < list.size() )list.remove(left);
        }

        return answer;
    }

}
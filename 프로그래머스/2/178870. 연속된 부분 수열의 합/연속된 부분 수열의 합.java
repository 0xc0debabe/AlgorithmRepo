import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 1, 1, 2, 3, 4, 5};
        sol.solution(arr, 5);
    }

    public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 0;
        int sum = sequence[0];

        List<int[]> list = new ArrayList<>();
        while (s <= e) {
            if (sum < k) {
                e++;
                if (e > sequence.length - 1) break;
                sum += sequence[e];
            } else if (sum > k) {
                sum -= sequence[s];
                s++;
            } else {
                list.add(new int[]{s, e});
                sum -= sequence[s];
                s++;
            }

        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ((o2[1] - o2[0]) == (o1[1] - o1[0])) {
                    return o1[0] - o2[0];
                }
                return  (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });

        return list.get(0);
    }

}
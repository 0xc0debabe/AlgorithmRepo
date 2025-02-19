import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] people = {70, 50, 80};
        solution.solution(people, 100);
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int answer = 0;
        int idx = 0;
        for (int i = n - 1; i >= idx; i--) {
            if (limit >= people[i] + people[idx]) {
                idx++;
            }

            answer++;
        }

        return answer;
    }

}


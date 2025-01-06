import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ids = {"muzi", "frodo", "apeach", "neo"};
        String[] rep = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    }

    public int solution(int[] numbers) {
        boolean[] isVisited = new boolean[10];
        for (int number : numbers) {
            isVisited[number] = true;
        }
        int answer = 0;
        for (int i = 1; i <= 9; i++) {
            if (!isVisited[i]) answer += i;
        }

        return answer;
    }

}

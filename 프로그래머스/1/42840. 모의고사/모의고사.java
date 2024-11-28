
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int f = 0;
        int s = 0;
        int t = 0;
        int max = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int fLen = first.length;
            int sLen = second.length;
            int tLen = third.length;

            if (first[i % fLen] == answer) {
                f++;
            }

            if (second[i % sLen] == answer) {
                s++;
            }

            if (third[i % tLen] == answer) {
                t++;
            }

            max = Math.max(f, Math.max(s, t));
        }

        List<Integer> list = new ArrayList<>();
        if (f == max) {
            list.add(1);
        }
        if (s == max) {
            list.add(2);
        }
        if (t == max) {
            list.add(3);
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
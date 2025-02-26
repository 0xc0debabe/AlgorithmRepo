import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        String prevWord = "";
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (i != 0 && prevWord.charAt(prevWord.length() - 1) != word.charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else if (map.containsKey(word)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            map.put(word, true);
            prevWord = word;
        }

        return answer;
    }

}




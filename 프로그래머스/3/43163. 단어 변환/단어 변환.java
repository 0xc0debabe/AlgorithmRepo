class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        solution.solution("hit", "cog", arr);
    }

    boolean[] isVisited;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        dfs(words, begin, target, 0);
        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    private void dfs(String[] words, String prevWord, String target, int depth) {
        if (target.equals(prevWord)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && isSimilar(words[i], prevWord)) {
                isVisited[i] = true;
                dfs(words, words[i], target, depth + 1);
                isVisited[i] = false;
            }
        }
    }


    private boolean isSimilar(String word, String prevWord) {
        if (prevWord.isEmpty()) return true;

        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i);
            char c2 = prevWord.charAt(i);

            if (c1 != c2) {
                if (!flag) flag = true;
                else return false;
            }
        }

        return true;
    }

}

class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        s.solution("E");
    }

    boolean flag = false;
    int answer = 0;
    public int solution(String word) {
        dfs(0, "A", word);
        dfs(0, "E", word);
        dfs(0, "I", word);
        dfs(0, "O", word);
        dfs(0, "U", word);
        return answer;
    }

    public void dfs(int depth, String s, String word) {
        if (flag) return;

        if (depth == 5) {
            return;
        }

        answer++;
        if (s.equals(word)) {
            flag = true;
            return;
        }

        dfs(depth + 1, s + "A", word);
        dfs(depth + 1, s + "E", word);
        dfs(depth + 1, s + "I", word);
        dfs(depth + 1, s + "O", word);
        dfs(depth + 1, s + "U", word);
    }
}

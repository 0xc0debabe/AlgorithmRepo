import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ui = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bi = {"fr*d*", "abc1**"};
        solution.solution(ui, bi);
    }

    boolean[] userVisited;
    boolean[] banVisited;
    Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        userVisited = new boolean[user_id.length];
        banVisited = new boolean[banned_id.length];
        dfs(user_id, banned_id, 0, banned_id.length);
        return set.size();
    }

    private void dfs(String[] user_id, String[] banned_id, int depth, int n) {
        StringBuilder sb = new StringBuilder();
        if (n == depth) {
            for (int i = 0; i < userVisited.length; i++) {
                if (userVisited[i]) {
                    sb.append(i);
                }
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!userVisited[i] && isSimilar(user_id[i], banned_id[depth])) {
                userVisited[i] = true;
                banVisited[depth] = true;
                dfs(user_id, banned_id, depth + 1, n);
                userVisited[i] = false;
                banVisited[depth] = false;
            }
        }
    }

    private boolean isSimilar(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;

        for (int i = 0; i < userId.length(); i++) {
            char u = userId.charAt(i);
            char b = bannedId.charAt(i);

            if (b == '*') continue;
            if (u != b) return false;
        }

        return true;
    }


}
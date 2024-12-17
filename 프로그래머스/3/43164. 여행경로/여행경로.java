
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] arr = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        solution.solution(arr);
    }

    boolean[] isVisited;
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        isVisited = new boolean[tickets.length];
        dfs("ICN", "ICN ", tickets, 0);
        return result.get(0).split(" ");
    }

    private void dfs(String start, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            result.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !isVisited[i]) {
                isVisited[i] = true;
                dfs(tickets[i][1], path + tickets[i][1] + " ", tickets, depth + 1);
                isVisited[i] = false;
            }
        }
    }


}

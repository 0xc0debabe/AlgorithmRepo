import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] infos = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
//        int[] infos = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}};
        solution.solution(infos, edges);
    }

    List<List<Integer>> list = new ArrayList<>();
    int[] info;
    int max = 0;
    public int solution(int[] infos, int[][] edges) {
        for (int i = 0; i < infos.length; i++) list.add(new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            list.get(from).add(to);
        }

        info = infos;
        List<Integer> nextNodeList = new ArrayList<>();
        nextNodeList.add(0);

        dfs(0, 0, 0, nextNodeList);
        return max;
    }

    private void dfs(int nowIdx, int sheep, int wolf, List<Integer> prevNodeList) {
        if (info[nowIdx] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) return;

        max = Math.max(max, sheep);

        List<Integer> nowNodeList = new ArrayList<>(prevNodeList);
        nowNodeList.addAll(list.get(nowIdx));
        nowNodeList.remove(Integer.valueOf(nowIdx));

        for (int next : nowNodeList) {
            dfs(next, sheep, wolf, nowNodeList);
        }
    }



}
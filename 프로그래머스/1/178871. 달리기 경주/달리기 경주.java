

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {"mumu", "soe", "poe", "kai", "mine"};
        String[] a = {"kai", "kai", "mine", "mine"};

        solution.solution(s, a);
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            swap(players, calling, map);
        }

        return players;
    }

    private void swap(String[] players, String calling, Map<String, Integer> map) {
        int callingNum = map.get(calling);
        String tmp = players[callingNum - 1];
        players[callingNum - 1] = calling;
        players[callingNum] = tmp;

        map.put(calling, callingNum - 1);
        map.put(tmp, callingNum);
    }

}

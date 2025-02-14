import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] info, int n, int m) {
        // 메모이제이션을 위한 Map (key: "A의 흔적,B의 흔적,현재 인덱스")
        Map<String, Integer> memo = new HashMap<>();
        int result = dfs(info, n, m, 0, 0, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[][] info, int n, int m, int index, int aTrace, int bTrace, Map<String, Integer> memo) {
        // 경찰에 걸리는 경우
        if (aTrace >= n || bTrace >= m) {
            return Integer.MAX_VALUE;
        }

        // 모든 물건을 훔친 경우
        if (index == info.length) {
            return aTrace; // A의 흔적 최소값 반환
        }

        // 메모이제이션 체크
        String key = aTrace + "," + bTrace + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // A가 가져가는 경우
        int takeA = dfs(info, n, m, index + 1, aTrace + info[index][0], bTrace, memo);
        
        // B가 가져가는 경우
        int takeB = dfs(info, n, m, index + 1, aTrace, bTrace + info[index][1], memo);

        // 최솟값 선택
        int result = Math.min(takeA, takeB);
        memo.put(key, result);
        return result;
    }
}
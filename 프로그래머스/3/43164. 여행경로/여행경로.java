import java.util.*;

class Solution {
    boolean[] visited; // 티켓 사용 여부를 저장하는 배열
    List<String> result; // 가능한 경로를 저장
    
    public String[] solution(String[][] tickets) {
        // 티켓을 정렬 (도착지 기준으로 알파벳 순)
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        // DFS 탐색 시작
        dfs("ICN", "ICN", tickets, 0);
        
        // 결과 반환
        return result.get(0).split(" ");
    }
    
    private void dfs(String current, String path, String[][] tickets, int count) {
        // 모든 티켓을 사용한 경우
        if (count == tickets.length) {
            result.add(path); // 경로 저장
            return;
        }
        
        // 현재 공항에서 출발 가능한 티켓 탐색
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true; // 티켓 사용
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false; // 티켓 복구 (백트래킹)
            }
        }
    }
}
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // LinkedList를 대체하기 위해 배열과 연결 정보를 사용
        int[] up = new int[n];   // 각 행의 위쪽 인덱스
        int[] down = new int[n]; // 각 행의 아래쪽 인덱스
        boolean[] exists = new boolean[n]; // 행이 삭제되었는지 여부
        Stack<Integer> deleted = new Stack<>(); // 삭제된 행을 저장할 스택

        // 연결 리스트 초기화
        for (int i = 0; i < n; i++) {
            up[i] = i - 1; // 현재 행의 위쪽 행 인덱스
            down[i] = i + 1; // 현재 행의 아래쪽 행 인덱스
            exists[i] = true; // 초기에는 모든 행이 존재
        }
        down[n - 1] = -1; // 마지막 행은 아래가 없음

        // 현재 선택된 행
        int cur = k;

        for (String c : cmd) {
            String[] parts = c.split(" ");
            char action = parts[0].charAt(0);

            if (action == 'U') { // 위로 이동
                int X = Integer.parseInt(parts[1]);
                while (X-- > 0) cur = up[cur];
            } else if (action == 'D') { // 아래로 이동
                int X = Integer.parseInt(parts[1]);
                while (X-- > 0) cur = down[cur];
            } else if (action == 'C') { // 현재 행 삭제
                deleted.push(cur); // 삭제된 행 저장
                exists[cur] = false;

                // 연결 정보 갱신
                if (up[cur] != -1) down[up[cur]] = down[cur]; // 위쪽 행이 있다면 아래 행과 연결
                if (down[cur] != -1) up[down[cur]] = up[cur]; // 아래쪽 행이 있다면 위 행과 연결

                // 새로운 선택된 행 지정 (아래가 없으면 위로 이동)
                cur = (down[cur] != -1) ? down[cur] : up[cur];
            } else if (action == 'Z') { // 가장 최근 삭제된 행 복구
                int restore = deleted.pop();
                exists[restore] = true;

                // 연결 정보 복구
                if (up[restore] != -1) down[up[restore]] = restore;
                if (down[restore] != -1) up[down[restore]] = restore;
            }
        }

        // 최종 결과 생성
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(exists[i] ? 'O' : 'X');
        }

        return result.toString();
    }
}
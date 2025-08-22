import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] pop;                 // 인구
    static List<Integer>[] adj;       // 인접 리스트 (1-indexed)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        pop = new int[N + 1];
        adj = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            pop[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int v = Integer.parseInt(st.nextToken());
                adj[i].add(v);
                adj[v].add(i); // 중복 추가되지만 문제에서 양방향이라 한 번만 넣어도 OK, 여기선 간단히 양쪽 다 넣어도 무방
            }
        }

        int answer = Integer.MAX_VALUE;

        // 1 ~ (1<<N)-1 까지 부분집합 순회 (양쪽 모두 비지 않도록 절반만 보거나 전체에서 공집합/전체집합 제외)
        for (int mask = 1; mask < (1 << N); mask++) {
            if (mask == (1 << N) - 1) continue; // 전체집합 제외 (B가 공집합)
            // A = mask, B = ~mask
            if (isConnected(mask) && isConnected(((1 << N) - 1) ^ mask)) {
                int diff = Math.abs(sumPopulation(mask) - sumPopulation(((1 << N) - 1) ^ mask));
                answer = Math.min(answer, diff);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 부분집합 mask가 연결인지 확인 (노드 인덱스는 1..N, mask는 0..N-1 비트 사용)
    static boolean isConnected(int mask) {
        // 공집합이면 연결 아님
        if (mask == 0) return false;

        // BFS 시작 노드 찾기
        int start = -1;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                start = i + 1; // 1-index 노드
                break;
            }
        }

        boolean[] vis = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;
        int visitedCnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : adj[cur]) {
                // nxt가 같은 부분집합(mask)에 속하고 아직 방문 안했으면
                if (!vis[nxt] && ((mask & (1 << (nxt - 1))) != 0)) {
                    vis[nxt] = true;
                    visitedCnt++;
                    q.add(nxt);
                }
            }
        }

        // mask에 포함된 노드 수와 BFS로 방문한 수가 같으면 연결
        return visitedCnt == Integer.bitCount(mask);
    }

    static int sumPopulation(int mask) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) sum += pop[i + 1];
        }
        return sum;
    }
}
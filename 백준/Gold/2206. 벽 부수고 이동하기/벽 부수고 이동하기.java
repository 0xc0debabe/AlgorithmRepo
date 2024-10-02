import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] di = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dj = { 0, 0, -1, 1 };

	static int N, M, ans;
	static int[][] visited;
	static int[][] map;

	static class Pos {
		int i;
		int j;
		int dis; // 이동거리
		int drill; // 공사횟수

		public Pos(int i, int j, int dis, int drill) {
			super();
			this.i = i;
			this.j = j;
			this.dis = dis;
			this.drill = drill;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		N = Integer.parseInt(srr[0]);
		M = Integer.parseInt(srr[1]);
		map = new int[N][M];
		visited = new int[N][M];

		// input
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;	//무한대로 초기화
			}
		}
		ans = Integer.MAX_VALUE;

		bfs(0, 0);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void bfs(int si, int sj) {
		Queue<Pos> q = new LinkedList<>();
		// 시작점부터 탐색시작
		q.add(new Pos(0, 0, 1, 0));
		visited[si][sj] = 0; // 처음 공사횟수

		// 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			Pos pos = q.poll();

			// 이동한 값이 종료 지점이라면 종료
			if (pos.i == N - 1 && pos.j == M - 1) {
				ans = pos.dis;
				break;
			}
			// 4방향 탐색
			for (int dir = 0; dir < 4; dir++) {
				int ni = pos.i + di[dir];
				int nj = pos.j + dj[dir];

				// 범위가 넘으면 다시 올라가서 4방향 탐색
				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;
				
				// "다음 위치의 공사횟수 <= 현재위치의 공사횟수"이면 큐에 추가하지 않고 넘어가도 됨(?????)
				if(visited[ni][nj] <= pos.drill)
					continue;

				// 벽이 아닐 때
				if(map[ni][nj]==0) {
					visited[ni][nj] = pos.drill;
					q.add(new Pos(ni, nj, pos.dis+1, pos.drill));
				}
				// 벽일 때
				else {
					if(pos.drill==0) {
						visited[ni][nj] = pos.drill + 1;
						q.add(new Pos(ni, nj, pos.dis+1, pos.drill+1));
					}
				}
			}
		}
	}

}

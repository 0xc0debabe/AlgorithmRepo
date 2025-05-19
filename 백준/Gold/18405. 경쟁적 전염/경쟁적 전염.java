import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                graph.get(arr[i][j]).add(new int[]{i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (s-- > 0) {

            for (int i = 1; i <= k; i++) {
                List<int[]> virusPos = graph.get(i);
                List<int[]> newVirusPos = new ArrayList<>();

                for (int[] pos : virusPos) {
                    for (int d = 0; d < 4; d++) {
                        int nr = pos[0] + dr[d];
                        int nc = pos[1] + dc[d];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && arr[nr][nc] == 0) {
                            arr[nr][nc] = i;
                            newVirusPos.add(new int[]{nr, nc});
                        }
                    }
                }

                graph.get(i).clear();
                graph.get(i).addAll(newVirusPos);
            }
        }

        System.out.println(arr[x - 1][y - 1]);
    }

}

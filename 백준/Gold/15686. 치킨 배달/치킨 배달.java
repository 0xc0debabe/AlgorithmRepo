import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static List<Node> house = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1){
                    house.add(new Node(i, j));
                } else if (board[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        isVisited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == m) {

            int[] arr = new int[house.size()];
            Arrays.fill(arr, Integer.MAX_VALUE);
            for (int i = 0; i < isVisited.length; i++) {
                if (isVisited[i]) {
                    Node node = chicken.get(i);
                    int r1 = node.row;
                    int c1 = node.col;

                    for (int j = 0; j < house.size(); j++) {
                        Node node1 = house.get(j);
                        int r2 = node1.row;
                        int c2 = node1.col;

                        int cal = calculate(r1, c1, r2, c2);
                        arr[j] = Math.min(arr[j], cal);
                    }
                }
            }

            answer = Math.min(answer, Arrays.stream(arr).sum());
            return;
        }

        for (int i = idx; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(depth + 1, i + 1);
                isVisited[i] = false;
            }
        }
    }



    static int calculate(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
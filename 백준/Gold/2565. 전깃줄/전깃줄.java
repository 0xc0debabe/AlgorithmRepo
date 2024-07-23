import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        nodes[0] = new Node(0, 0);
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }

        int[] dp = new int[n + 1];
        Arrays.sort(nodes);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (
                    (nodes[i].x > nodes[j].x && nodes[i].y > nodes[j].y) ||
                    (nodes[i].x < nodes[j].x && nodes[i].y < nodes[j].y)
                ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x - o.x;
    }
}
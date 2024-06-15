import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            answer = 0;
            st = new StringTokenizer(br.readLine());
            int currKnightX = Integer.parseInt(st.nextToken());
            int currKnightY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int arriveKnightX = Integer.parseInt(st.nextToken());
            int arriveKnightY = Integer.parseInt(st.nextToken());
            board[arriveKnightX][arriveKnightY] = -1;
            bfs(currKnightX, currKnightY, n);
            System.out.println(answer);
        }
    }

    static void bfs(int currKnightX, int currKnightY, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>((x, y) -> x.depth - y.depth);
        queue.add(new Node(currKnightX, currKnightY, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.currX < 0 || poll.currY < 0 || poll.currX >= n || poll.currY >= n || board[poll.currX][poll.currY] == 1) {
                continue;
            }

            if (board[poll.currX][poll.currY] == -1) {
                answer = poll.depth;
                break;
            }

            board[poll.currX][poll.currY] = 1;

            queue.add(new Node(poll.currX + 2, poll.currY - 1, poll.depth + 1));
            queue.add(new Node(poll.currX + 1, poll.currY - 2, poll.depth + 1));

            queue.add(new Node(poll.currX - 1, poll.currY - 2, poll.depth + 1));
            queue.add(new Node(poll.currX - 2, poll.currY - 1, poll.depth + 1));

            queue.add(new Node(poll.currX - 2, poll.currY + 1, poll.depth + 1));
            queue.add(new Node(poll.currX - 1, poll.currY + 2, poll.depth + 1));

            queue.add(new Node(poll.currX + 1, poll.currY + 2, poll.depth + 1));
            queue.add(new Node(poll.currX + 2, poll.currY + 1, poll.depth + 1));
        }
    }

    static void dfs(int currKnightX, int currKnightY, int n, int depth) {
        if (currKnightX < 0 || currKnightY < 0 || currKnightX >= n || currKnightY >= n || answer < depth || board[currKnightX][currKnightY] == 1) {
            return;
        }

        if (board[currKnightX][currKnightY] == -1) {
            answer = Math.min(answer, depth);
            return;
        }

        board[currKnightX][currKnightY] = 1;
        dfs(currKnightX + 2, currKnightY - 1, n, depth + 1);
        dfs(currKnightX + 1, currKnightY - 2, n, depth + 1);

        dfs(currKnightX - 1, currKnightY - 2, n, depth + 1);
        dfs(currKnightX - 2, currKnightY - 1, n, depth + 1);

        dfs(currKnightX - 2, currKnightY + 1, n, depth + 1);
        dfs(currKnightX - 1, currKnightY + 2, n, depth + 1);

        dfs(currKnightX + 1, currKnightY + 2, n, depth + 1);
        dfs(currKnightX + 2, currKnightY + 1, n, depth + 1);
    }
}

class Node {
    int currX;
    int currY;
    int depth;

    public Node(int currX, int currY, int depth) {
        this.currX = currX;
        this.currY = currY;
        this.depth = depth;
    }
}


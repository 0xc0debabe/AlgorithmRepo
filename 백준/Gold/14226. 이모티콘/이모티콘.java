import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, answer;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        isVisited = new boolean[2_001][2_001];
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));
        // queue의 값은 화면에 이모티콘 개수
        isVisited[1][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.emoticonNum == n) {
                answer = now.time;
                break;
            }

            if (!isVisited[now.emoticonNum][now.emoticonNum]) {
                isVisited[now.emoticonNum][now.emoticonNum] = true;
                queue.add(new Node(now.emoticonNum, now.emoticonNum, now.time + 1));
            }

            if (
                    now.clipboard > 0
                    && now.emoticonNum + now.clipboard <= 2000
                    && !isVisited[now.emoticonNum + now.clipboard][now.clipboard]) {
                queue.add(new Node(now.emoticonNum + now.clipboard, now.clipboard, now.time + 1));
                isVisited[now.emoticonNum + now.clipboard][now.clipboard] = true;
            }

            if (now.emoticonNum > 1 && !isVisited[now.emoticonNum - 1][now.clipboard]) {
                queue.add(new Node(now.emoticonNum - 1, now.clipboard, now.time + 1));
                isVisited[now.emoticonNum - 1][now.clipboard] = true;
            }

        }
    }
}

class Node {
    int emoticonNum;
    int clipboard;
    int time;

    public Node(int emoticonNum, int clipboard, int time) {
        this.emoticonNum = emoticonNum;
        this.clipboard = clipboard;
        this.time = time;
    }
}

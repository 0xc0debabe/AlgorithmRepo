import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, answer;
    static boolean[][] isVisited;  // [이모티콘 개수][클립보드 개수]로 방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        isVisited = new boolean[2001][2001];  // 이모티콘 개수와 클립보드 개수 모두 최대 2000까지
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));  // 초기 상태: 화면에 1개의 이모티콘, 클립보드 0, 시간 0
        isVisited[1][0] = true;  // 1개의 이모티콘, 0개의 클립보드 상태 방문 기록

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.emoticonNum == n) {  // 원하는 이모티콘 개수에 도달하면 종료
                answer = now.time;
                break;
            }

            // 1. 복사: 현재 화면의 이모티콘을 클립보드에 복사
            if (!isVisited[now.emoticonNum][now.emoticonNum]) {
                queue.add(new Node(now.emoticonNum, now.emoticonNum, now.time + 1));
                isVisited[now.emoticonNum][now.emoticonNum] = true;
            }

            // 2. 붙여넣기: 클립보드에 있는 이모티콘을 화면에 붙여넣기
            if (now.clipboard > 0 && now.emoticonNum + now.clipboard <= 2000 && !isVisited[now.emoticonNum + now.clipboard][now.clipboard]) {
                queue.add(new Node(now.emoticonNum + now.clipboard, now.clipboard, now.time + 1));
                isVisited[now.emoticonNum + now.clipboard][now.clipboard] = true;
            }

            // 3. 삭제: 화면에 있는 이모티콘 1개 삭제
            if (now.emoticonNum > 1 && !isVisited[now.emoticonNum - 1][now.clipboard]) {
                queue.add(new Node(now.emoticonNum - 1, now.clipboard, now.time + 1));
                isVisited[now.emoticonNum - 1][now.clipboard] = true;
            }
        }
    }
}

class Node {
    int emoticonNum;  // 화면에 있는 이모티콘 개수
    int clipboard;    // 클립보드에 있는 이모티콘 개수
    int time;         // 소요된 시간

    public Node(int emoticonNum, int clipboard, int time) {
        this.emoticonNum = emoticonNum;
        this.clipboard = clipboard;
        this.time = time;
    }
}
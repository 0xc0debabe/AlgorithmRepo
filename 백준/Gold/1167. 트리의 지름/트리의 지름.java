import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int linkedNum;
    int distance;

    public Node(int linkedNum, int distance) {
        this.linkedNum = linkedNum;
        this.distance = distance;
    }
}

public class Main {
    static boolean[] visited;
    static List<Node>[] lists;
    static int[] distanceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(stk.nextToken());
            while (true) {
                int num = Integer.parseInt(stk.nextToken());
                if (num == -1) {
                    break;
                }
                int distance = Integer.parseInt(stk.nextToken());
                lists[vertex].add(new Node(num, distance));
            }
        }
        visited = new boolean[n + 1];
        distanceArr = new int[n + 1];

        dfs(1);
//        bfs(1);

        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 2; i < distanceArr.length; i++) {
            if (distanceArr[i] > max) {
                max = distanceArr[i];
                tmp = i;
            }
        }
        Arrays.fill(visited, false);
        Arrays.fill(distanceArr, 0);
        dfs(tmp);
//        bfs(tmp);
        Arrays.sort(distanceArr);
        System.out.println(distanceArr[n]);
    }

    static void bfs(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(n);
        visited[n] = true;

        while (!deque.isEmpty()) {
            int poll = deque.pollLast();

            for (Node node : lists[poll]) {
                int num = node.linkedNum;
                int dist = node.distance;

                if (!visited[num]) {
                    visited[num] = true;
                    deque.addFirst(num);
                    distanceArr[num] = distanceArr[poll] + dist;
                }
            }
        }
    }

    static void dfs(int num) {
        visited[num] = true;
        for (Node node : lists[num]) {
            int linkedNum = node.linkedNum;
            int dist = node.distance;

            if (!visited[linkedNum]) {
                distanceArr[linkedNum] = dist + distanceArr[num];
                dfs(linkedNum);
            }
        }
    }
}
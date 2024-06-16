import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> lists;
    static boolean[] isVisited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetParent = Integer.parseInt(st.nextToken());
        int targetChild = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            lists.get(parent).add(new Node(child, 0));
            lists.get(child).add(new Node(parent, 0));
        }

        boolean bool = bfs(targetParent, targetChild);
        if (bool) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static boolean bfs(int targetP, int targetC) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(targetP, 0));
        boolean check = false;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.num == targetC) {
                check = true;
                answer = now.depth;
                break;
            }

            for (Node next : lists.get(now.num)) {
                if (!isVisited[next.num]) {
                    isVisited[next.num] = true;
                    queue.add(new Node(next.num, now.depth + 1));
                }
            }
        }

        return check;
    }
}

class Node {
    int num;
    int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}

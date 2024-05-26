import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> lists;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n];
        lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = change(st.nextToken());
            int leftChild = change(st.nextToken());
            int rightChild = change(st.nextToken());
            lists.get(parent).add(new Node(leftChild, rightChild));
        }

        dfs(0);
        sb.append("\n");
        dfs2(0);
        sb.append("\n");
        dfs3(0);

        System.out.println(sb);
    }

    static int change(String s) {
        if (s.equals(".")) return -1;
        return s.charAt(0) - 'A';
    }

    static void dfs(int n) {
        if (n == -1) return;
        sb.append((char) (n + 'A'));
        for (Node next : lists.get(n)) {
            dfs(next.left);
            dfs(next.right);
        }
    }

    static void dfs2(int n) {
        if (n == -1) return;

        for (Node next : lists.get(n)) {
            dfs2(next.left);
            sb.append((char) (n + 'A'));
            dfs2(next.right);
        }
    }

    static void dfs3(int n) {
        if (n == -1) return;

        for (Node next : lists.get(n)) {
            dfs3(next.left);
            dfs3(next.right);
            sb.append((char) (n + 'A'));
        }
    }


}

class Node {
    int left, right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
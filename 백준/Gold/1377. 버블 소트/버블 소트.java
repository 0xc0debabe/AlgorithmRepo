import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            nodes[i] = new Node(num, i);
        }
        Arrays.sort(nodes);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < nodes[i].idx - i) {
                max = nodes[i].idx - i;
            }
        }
        System.out.println(max + 1);
    }
}

class Node implements Comparable<Node>{
    int num;
    int idx;

    public Node(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node o) {
        return this.num - o.num;
    }
}
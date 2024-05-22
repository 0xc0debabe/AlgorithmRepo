import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[m + 1];
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(start, end, time);
        }
        
        distance[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node node = nodes[j];
                if (distance[node.start] != Integer.MAX_VALUE
                        && distance[node.end] > distance[node.start] + node.weight) {
                    distance[node.end] = distance[node.start] + node.weight;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < m; i++) {
            Node node = nodes[i];
            if (distance[node.start] != Integer.MAX_VALUE
                    && distance[node.end] > distance[node.start] + node.weight) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        } 
    }
}

class Node {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
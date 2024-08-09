import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(s, e);
        }

        Arrays.sort(nodes);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nodes[0].end);
        
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= nodes[i].start) {
                pq.poll();
            }
            
            pq.add(nodes[i].end);
        }

        System.out.println(pq.size());
    }
}

class Node implements Comparable<Node>{
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Node node) {
        if (this.start == node.start) {
            return this.end - node.end;
        }
        return this.start - node.start;
    }
}
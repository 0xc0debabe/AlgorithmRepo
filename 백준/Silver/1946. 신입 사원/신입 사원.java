import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b));
            }

            Collections.sort(list);
            int cnt = 0;

            int min = list.get(0).b;
            for (Node node : list) {
                if (node.b <= min) {
                    cnt++;
                    min = node.b;
                }
            }
            System.out.println(cnt);
        }
    }
}

class Node implements Comparable<Node>{
    int a;
    int b;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(Node node) {
        return this.a - node.a;
    }
}
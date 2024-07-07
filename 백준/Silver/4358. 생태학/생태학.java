import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        int cnt = 0;
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            map.put(s, map.getOrDefault(s, (double)0) + 1);
            cnt++;
        }

        Node[] nodes = new Node[map.size()];
        int idx = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            nodes[idx++] = new Node(entry.getKey(), String.format("%.4f", entry.getValue() * 100/ cnt));
        }
        Arrays.sort(nodes);
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.name).append(" ").append(node.score).append("\n");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node>{
    String name;
    String score;

    public Node(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
}
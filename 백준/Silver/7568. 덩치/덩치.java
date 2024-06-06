import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(weight, height, 0);
        }

        for (int i = 0; i < n; i++) {
            int grade = 1;
            for (int j = 0; j < n; j++) {
                if (nodes[i].weight < nodes[j].weight && nodes[i].height < nodes[j].height) {
                    grade++;
                }
            }
            nodes[i].grade = grade;
        }

        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.grade).append(" ");
        }
        System.out.println(sb);
    }
}

class Node {
    int weight;
    int height;
    int grade;

    public Node(int weight, int height, int grade) {
        this.weight = weight;
        this.height = height;
        this.grade = grade;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr = new int[3];
    static int min = Integer.MAX_VALUE;
    static Set<Node> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scvNum = Integer.parseInt(br.readLine());

        arr = new int[3];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < scvNum; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        dfs(arr[0], arr[1], arr[2], 0);
        System.out.println(min);
    }

    static void dfs(int a, int b, int c, int depth) {
        if (a <= 0 && b <= 0 && c <= 0) {
            if (min >= depth) {
                min = depth;
            }
            return;
        }

        int[] sort = new int[3];
        sort[0] = a;
        sort[1] = b;
        sort[2] = c;
        Arrays.sort(sort);
        boolean add = set.add(new Node(a, b, c));
        if (!add) return;

//        1 2 3
            dfs(a - 9, b - 3, c - 1, depth + 1);
//        1 3 2
            dfs(a - 9, c - 3, b - 1, depth + 1);

//        2 1 3
            dfs(b - 9, a - 3, c - 1, depth + 1);
//        2 3 1
            dfs(b - 9, c - 3, a - 1, depth + 1);

//        3 1 2
            dfs(c - 9, a - 3, b - 1, depth + 1);
//        3 2 1
            dfs(c - 9, b - 3, a - 1, depth + 1);


    }
}

class Node {
    int top;
    int mid;
    int bottom;

    public Node(int top, int mid, int bottom) {
        this.top = top;
        this.mid = mid;
        this.bottom = bottom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return top == node.top && mid == node.mid && bottom == node.bottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, mid, bottom);
    }
}

import java.util.*;

class Solution {
    static final int SIZE = 50;
    static final int N = SIZE * SIZE;
    int[] parent = new int[N];
    String[] values = new String[N];

    public String[] solution(String[] commands) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++) parent[i] = i;

        for (String command : commands) {
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "UPDATE":
                    if (parts.length == 4) {
                        int r = Integer.parseInt(parts[1]) - 1;
                        int c = Integer.parseInt(parts[2]) - 1;
                        String value = parts[3];
                        int index = r * SIZE + c;
                        int root = find(index);
                        values[root] = value;
                    } else {
                        String val1 = parts[1];
                        String val2 = parts[2];
                        for (int i = 0; i < N; i++) {
                            int root = find(i);
                            if (values[root] != null && values[root].equals(val1)) {
                                values[root] = val2;
                            }
                        }
                    }
                    break;

                case "MERGE":
                    int r1 = Integer.parseInt(parts[1]) - 1;
                    int c1 = Integer.parseInt(parts[2]) - 1;
                    int r2 = Integer.parseInt(parts[3]) - 1;
                    int c2 = Integer.parseInt(parts[4]) - 1;
                    int idx1 = r1 * SIZE + c1;
                    int idx2 = r2 * SIZE + c2;
                    union(idx1, idx2);
                    break;

                case "UNMERGE":
                    int r = Integer.parseInt(parts[1]) - 1;
                    int c = Integer.parseInt(parts[2]) - 1;
                    int idx = r * SIZE + c;
                    int root = find(idx);
                    String val = values[root];

                    List<Integer> toUnmerge = new ArrayList<>();
                    for (int i = 0; i < N; i++) {
                        if (find(i) == root) toUnmerge.add(i);
                    }
                    for (int i : toUnmerge) {
                        parent[i] = i;
                        values[i] = null;
                    }
                    values[idx] = val;
                    break;

                case "PRINT":
                    int pr = Integer.parseInt(parts[1]) - 1;
                    int pc = Integer.parseInt(parts[2]) - 1;
                    int pIdx = pr * SIZE + pc;
                    int pRoot = find(pIdx);
                    result.add(values[pRoot] != null ? values[pRoot] : "EMPTY");
                    break;
            }
        }

        return result.toArray(new String[0]);
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        // 우선순위: px의 값이 null이면 py에 붙이고, 아니면 py를 px에 붙임
        if (values[px] == null && values[py] != null) {
            parent[px] = py;
        } else {
            parent[py] = px;
        }
    }
}
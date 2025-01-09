import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        sol.solution(5, arr);
    }


    public int[] solution(int N, int[] stages) {
        int[] clear = new int[N + 1];
        for (int i = 0; i < stages.length; i++) {
            clear[stages[i] - 1]++;
        }

        Node[] nodes = new Node[N];
        int userNum = stages.length;

        for (int i = 0; i < clear.length - 1; i++) {
            int c = clear[i];
            if (c == 0) {
                nodes[i] = new Node(0, i);
                continue;
            }

            nodes[i] = new Node((double) c / userNum, i);
            userNum -= c;
        }
        return Arrays.stream(nodes).sorted().mapToInt(x -> x.idx + 1).toArray();
    }

    static class Node implements Comparable<Node>{
        double fail;
        int idx;

        public Node(double fail, int idx) {
            this.fail = fail;
            this.idx = idx;
        }

        public int compareTo(Node node) {
            if (node.fail == this.fail) {
                return this.idx - node.idx;
            }
            return Double.compare(node.fail, this.fail);
        }
    }

}

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        solution.solution(arr);
    }

    int[][] answer;
    int idx;
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;

        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) {
            int[] node = nodeinfo[i];
            nodes[i] = new Node(node[0], node[1], i + 1, null, null);
        }
        Arrays.sort(nodes);
        Node root = nodes[0];

        for (int i = 1; i < len; i++) {
            insert(root, nodes[i]);
        }
        answer = new int[2][len];
        idx = 0;
        preOrder(root);
        idx = 0;
        postOrder(root);

        return answer;
    }

    private void insert(Node root, Node child) {
        root = insertRec(root, child);
    }

    private Node insertRec(Node root, Node child) {
        if (root == null) {
            root = new Node(child.x, child.y, child.idx, null, null);
            return root;
        }

        if (root.x > child.x) {
            root.left = insertRec(root.left, child);
        } else {
            root.right = insertRec(root.right, child);
        }

        return root;
    }

    private void preOrder(Node now) {
        if (now == null) return;

        answer[0][idx++] = now.idx;
        preOrder(now.left);
        preOrder(now.right);
    }

    private void postOrder(Node now) {
        if (now == null) return;

        postOrder(now.left);
        postOrder(now.right);
        answer[1][idx++] = now.idx;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int idx;
        Node left;
        Node right;

        public Node(int x, int y, int idx, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node pos) {
            if (this.y == pos.y) {
                return this.x - pos.x;
            }
            return pos.y - this.y;
        }
    }

}
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {2, 2, 2, 2, 2, 10};
        System.out.println(sol.solution(10, 1, a));
    }

    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(new Node(i, enemy[i]));

            while (!pq.isEmpty() && n < 0) {
                if (k > 0) {
                    k--;
                    n += pq.poll().value;
                }

                if (k == 0) break;
            }
            if (n < 0 && k <= 0) break;


            answer = i + 1;
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        private int idx;
        private int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }



}
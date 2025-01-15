import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] targets = {{1, 2},{2, 3}};
        System.out.println(solution.solution(targets));
    }

    public int solution(int[][] targets) {
        PriorityQueue<Target> pq = new PriorityQueue<>();
        for (int[] target : targets) pq.add(new Target(target[0], target[1]));

        int startLine = Integer.MAX_VALUE;
        int endLine = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            Target now = pq.poll();
            if (now.s < endLine) {
                startLine = now.s;
                endLine = Math.min(endLine, now.e);
                continue;
            }

            startLine = now.s;
            endLine = now.e;
            answer++;
        }

        return answer;
    }

    static class Target implements Comparable<Target>{
        private int s;
        private int e;

        public Target(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Target target) {
            if (this.s == target.s) return this.e - target.e;

            return this.s - target.s;
        }
    }

}
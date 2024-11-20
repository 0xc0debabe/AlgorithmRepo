
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] a = {
                {0, 3}, {1, 9}, {3, 5}
        };
        System.out.println(s.solution(a));
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Node2> pq2 = new PriorityQueue<>();

        for (int i = 0; i < jobs.length; i++) {
            int start = jobs[i][0];
            int duration = jobs[i][1];
            pq2.add(new Node2(i, duration, start));
        }

        int currTime = 0;
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (!pq.isEmpty() || !pq2.isEmpty()) {

            while (!pq2.isEmpty() && pq2.peek().start <= currTime) {
                Node2 poll = pq2.poll();
                pq.add(new Node(poll.jobNum, poll.duration, poll.start));
            }

            if (!pq.isEmpty()) {
                Node now = pq.poll();
                answer += now.duration + currTime - now.start;
                currTime += now.duration;
            } else {
                currTime++;
            } 
        }

        return answer / jobs.length;
    }

    static class Node2 implements Comparable<Node2> {
        int jobNum;
        int duration;
        int start;

        public Node2(int jobNum, int duration, int start) {
            this.jobNum = jobNum;
            this.duration = duration;
            this.start = start;
        }

        @Override
        public int compareTo(Node2 o) {
            return this.start - o.start;
        }

    }

    static class Node implements Comparable<Node>{
        int jobNum;
        int duration;
        int start;

        public Node(int jobNum, int duration, int start) {
            this.jobNum = jobNum;
            this.duration = duration;
            this.start = start;
        }

        @Override
        public int compareTo(Node o) {
            if (this.duration == o.duration) {

                if (this.start == o.start) {
                    return this.jobNum - o.jobNum;
                }

                return this.start - o.start;
            }

            return this.duration - o.duration;
        }
    }
}

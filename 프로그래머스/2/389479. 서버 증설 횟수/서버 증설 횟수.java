import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        System.out.println(solution.solution(players, 3, 5));
    }

    public int solution(int[] players, int m, int k) {
        int playerCapacity = m - 1;

        int answer = 0;
        PriorityQueue<Server> pq = new PriorityQueue<>();

        for (int i = 0; i < players.length; i++) {

            int player = players[i];
            playerCapacity = (pq.size() + 1) * m - 1;

            if (playerCapacity < player) {
                int diff = player - playerCapacity;
                int tmp = diff % m == 0 ? 1 : 0;
                int serverQuantity = diff / m + 1 - tmp;
                answer += serverQuantity;
                for (int j = 0; j < serverQuantity; j++) {
                    pq.add(new Server(i + k, 1));
                }
            }

            stopServer(pq, i);
        }

        return answer;
    }

    private void stopServer(PriorityQueue<Server> pq, int nowTime) {
        if (pq.isEmpty()) return;

        while (!pq.isEmpty() && pq.peek().endTime - 1 <= nowTime) pq.poll();
        
    }

    static class Server implements Comparable<Server> {
        private int endTime;
        private int serverQuantity;

        public Server(int endTime, int serverQuantity) {
            this.endTime = endTime;
            this.serverQuantity = serverQuantity;
        }

        @Override
        public int compareTo(Server o) {
            return this.endTime - o.endTime;
        }
    }



}
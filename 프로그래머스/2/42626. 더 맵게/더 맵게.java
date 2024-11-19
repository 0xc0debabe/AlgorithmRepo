
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] sc = {3, 4, 5, 6, 7};
        System.out.println(s.solution(sc, 10));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        int cnt = 0;

        if (pq.peek() >= K) {
            return 0;
        }

        while (pq.size() > 1) {
            cnt++;

            int first = pq.poll();
            int second = pq.poll();
            int mixedFood = first + second * 2;

            if (mixedFood >= K) {

                if (!pq.isEmpty()) {
                    int next = pq.peek();
                    if (next >= K) {
                        return cnt;
                    } else {
                        pq.add(mixedFood);
                    }
                } else {
                    return cnt;
                }

            } else {
                pq.add(mixedFood);
            }

        }

        return -1;
    }

}

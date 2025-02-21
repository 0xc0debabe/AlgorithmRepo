
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 1, 3, 2};
        System.out.println(solution.solution(arr, 2));
    }

    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(i);
        }

        int idx = 0;
        while (!pq.isEmpty() && !queue.isEmpty()) {
            int poll = queue.poll();
            if (priorities[poll] == pq.peek()) {
                if (poll == location){
                    break;
                }

                pq.poll();
                idx++;
            } else {
                queue.add(poll);
            }

        }

        return idx + 1;
    }

}


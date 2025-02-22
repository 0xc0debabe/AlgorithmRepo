import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {7, 4, 5, 6};
        solution.solution(2, 10, arr);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            int truckWeight = truck_weights[i];

            if (queue.size() == bridge_length) {
                int poll = queue.poll();
                totalWeight -= poll;
            }

            if (totalWeight + truckWeight <= weight) {
                queue.add(truckWeight);
                totalWeight += truckWeight;
            } else {
                i--;
                queue.add(0);
            }

            time++;
        }

        time += bridge_length;

        return time;
    }

}


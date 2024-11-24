
import java.util.*;


class Solution {
    public static void main(String[] args) {
        int n = 2;
        int a = 10;
        int[] ar = {7, 4, 5, 6};
        Solution s = new Solution();
        s.solution(n, a, ar);

    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucksQ = new LinkedList<>();
        for (int tw : truck_weights) {
            trucksQ.add(tw);
        }

        int currTotalWeight = 0;
        int time = 0;
        Queue<Integer> bridge = new LinkedList<>();
        while (!trucksQ.isEmpty()) {
            time++;
            if (bridge.size() == bridge_length) {
                currTotalWeight -= bridge.poll();
            }

            if (!trucksQ.isEmpty()) {
                if (currTotalWeight + trucksQ.peek() <= weight) {
                    int currTruckWeight = trucksQ.poll();
                    bridge.add(currTruckWeight);
                    currTotalWeight += currTruckWeight;
                } else {
                    bridge.add(0);
                }
            }


        }

        return time + bridge_length;
    }

}
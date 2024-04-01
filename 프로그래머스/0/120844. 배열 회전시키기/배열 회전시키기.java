import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};

        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : numbers) {
            deque.addLast(num);
        }

        if (direction.equals("right")) {
            deque.addFirst(deque.pollLast());
        } else {
            deque.addLast(deque.pollFirst());
        }

        answer = deque.stream().mapToInt(i -> i.intValue()).toArray();

        return answer;
    }
}
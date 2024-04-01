import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int[] solution(int[] numbers, String direction) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : numbers) {
            deque.addLast(num);
        }

        if (direction.equals("right")) {
            deque.addFirst(deque.pollLast());
        } else {
            deque.addLast(deque.pollFirst());
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}
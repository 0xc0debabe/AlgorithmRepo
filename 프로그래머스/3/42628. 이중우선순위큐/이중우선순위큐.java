import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        solution.solution(s);
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>((x, y) -> y - x);
        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("I")) {
                asc.add(Integer.parseInt(split[1]));
                desc.add(Integer.parseInt(split[1]));
            } else {
                if (!asc.isEmpty()) {
                    if (split[1].equals("1")) {
                        Integer poll = desc.poll();
                        asc.remove(poll);
                    } else {
                        Integer poll = asc.poll();
                        desc.remove(poll);
                    }
                }
            }
        }

        int[] answer = new int[2];
        if (asc.isEmpty()) return answer;
        answer[0] = desc.poll();
        answer[1] = asc.poll();
        return answer;
    }

}
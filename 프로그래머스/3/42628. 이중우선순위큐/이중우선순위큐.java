
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        String[] sa = {"I -45",
                "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        s.solution(sa);

    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> des = new PriorityQueue<>((x, y) -> y - x);
        Map<Integer, Integer> map = new HashMap<>();

        for (String s : operations) {
            String[] split = s.split(" ");

            if (split[0].equals("I")) {
                int v = Integer.parseInt(split[1]);
                asc.add(v);
                des.add(v);
                map.put(v, map.getOrDefault(v, 0) + 1);
            } else {
                if (split[1].equals("-1")) {
                    while (!asc.isEmpty()) {
                        int poll = asc.poll();
                        int count = map.get(poll);

                        if (count > 0) {
                            map.put(poll, count - 1);
                            break;
                        }

                    }
                } else {
                    while (!des.isEmpty()) {
                        int poll = des.poll();
                        int count = map.get(poll);

                        if (count > 0) {
                            map.put(poll, count - 1);
                            break;
                        }
                    }
                }
            }
        }

        if (asc.isEmpty() || des.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int[] answer = new int[2];

            while (!des.isEmpty()) {
                int poll = des.poll();
                int count = map.get(poll);

                if (count > 0) {
                    map.put(poll, count - 1);
                    answer[0] = poll;
                    answer[1] = poll;
                    break;
                }
            }
            while (!asc.isEmpty()) {
                int poll = asc.poll();
                int count = map.get(poll);

                if (count > 0) {
                    map.put(poll, count - 1);
                    answer[1] = poll;
                    break;
                }
            }

            return answer;
        }
    }

}

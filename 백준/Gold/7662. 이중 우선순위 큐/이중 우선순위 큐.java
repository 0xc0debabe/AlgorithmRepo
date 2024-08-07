import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();

                if (s.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    max.add(num);
                    min.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else if (s.equals("D")) {
                    int type = Integer.parseInt(st.nextToken());
                    if (!map.isEmpty()) {
                        if (type == 1) {
                            delete(max);
                        } else {
                            delete(min);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            }

            int answer = 0;
            answer = delete(max);
            sb.append(answer).append(" ");
            if (!map.isEmpty()) {
                answer = delete(min);
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static int delete(PriorityQueue<Integer> pq) {
        int res = 0;

        while (true) {
            res = pq.poll();
            int cnt = map.getOrDefault(res, 0);
            if (cnt == 0) continue;

            if (cnt == 1) {
                map.remove(res);
            } else {
                map.put(res, map.get(res) - 1);
            }

            break;
        }

        return res;
    }
}

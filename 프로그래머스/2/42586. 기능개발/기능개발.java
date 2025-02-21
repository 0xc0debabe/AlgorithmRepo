import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {95, 90, 99, 99, 80, 99};
        int[] sp = {1, 1, 1, 1, 1, 1};
        int[] solution1 = solution.solution(arr, sp);
        for (int i : solution1) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int[] taskPerUnit = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int remainTask = 100 - progress;
            int tmp = remainTask % speed == 0 ? 0 : 1;
            int dayPerTask = remainTask / speed + tmp;
            taskPerUnit[i] = dayPerTask;
        }

        int max = taskPerUnit[0];
        int cnt = 0;
        for (int i = 0; i < taskPerUnit.length; i++) {
            if (max < taskPerUnit[i]) {
                max = taskPerUnit[i];
                list.add(cnt);
                cnt = 1;
                continue;
            }

            cnt++;
        }

        if (cnt == 0) list.add(1);
        else list.add(cnt);
        return list.stream().mapToInt(i -> i).toArray();
    }

}


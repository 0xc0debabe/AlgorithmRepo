import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {

    }

    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int min = Integer.MAX_VALUE;
        for (int v : arr) {
            min = Math.min(min, v);
        }

        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        for (int v : arr) {
            if (!flag) {
                if (v == min) {
                    flag = true;
                    continue;
                }
            }

            list.add(v);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

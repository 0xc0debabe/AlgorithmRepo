import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] points1 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes1 = {{4, 2}, {1, 3}, {2, 4}};
        System.out.println(solution.solution(points1, routes1)); // 출력: 1

        int[][] points2 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes2 = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        System.out.println(solution.solution(points2, routes2)); // 출력: 9

        int[][] points3 = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes3 = {{2, 3, 4, 5}, {1, 3, 4, 5}};
        System.out.println(solution.solution(points3, routes3)); // 출력: 0
    }

    public int solution(int[][] points, int[][] routes) {
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            pointMap.put(i + 1, point);
        }

//


        String[][] footprint = new String[routes.length][];
        for (int i = 0; i < routes.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < routes[i].length; j++) {
                if (j == 0) {
                    int[] startPos = pointMap.get(routes[i][j]).clone();
                    sb.append('r').append(startPos[0]).append('c').append(startPos[1]).append(',');
                    continue;
                }
                int[] from = pointMap.get(routes[i][j - 1]).clone();
                int[] to = pointMap.get(routes[i][j]).clone();

                while (from[0] != to[0] || from[1] != to[1]) {
                    if (from[0] < to[0]) {
                        from[0]++;
                    } else if (from[0] > to[0]) {
                        from[0]--;
                    } else if (from[1] < to[1]) {
                        from[1]++;
                    } else {
                        from[1]--;
                    }
                    sb.append('r').append(from[0]).append('c').append(from[1]).append(',');
                }
            }

            footprint[i] = sb.toString().split(",");
        }

        int max = 0;
        int answer = 0;
        for (int i = 0; i < footprint.length; i++) max = Math.max(max, footprint[i].length);
        for (int i = 0; i < max; i++) {
            Map<String, Integer> dangerous = new HashMap<>();

            for (int j = 0; j < routes.length; j++) {
                if (i < footprint[j].length) {
                    String key = footprint[j][i];
                    dangerous.put(key, dangerous.getOrDefault(key, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : dangerous.entrySet()) {
                if (entry.getValue() >= 2) answer++;
            }
        }

        return answer;
    }


}
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String dirs = "LULLLLLLU";
        System.out.println(solution.solution(dirs));
    }

    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Map<Character, int[]> moveMap = new HashMap<>();
        moveMap.put('U', directions[0]);
        moveMap.put('D', directions[1]);
        moveMap.put('R', directions[2]);
        moveMap.put('L', directions[3]);
        
        int answer = 0;
        
        for (char dir : dirs.toCharArray()) {
            int nx = x + moveMap.get(dir)[0];
            int ny = y + moveMap.get(dir)[1];
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue; // 경계를 넘어가면 무시
            }
            
            String path1 = x + "," + y + "-" + nx + "," + ny;
            String path2 = nx + "," + ny + "-" + x + "," + y;
            
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}

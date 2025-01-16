import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] result = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            List<Integer> distances = new ArrayList<>();
            
            // 반사된 목표 지점 계산
            // 위쪽 벽 반사
            distances.add(distanceSquared(startX, startY, targetX, 2 * n - targetY));
            // 아래쪽 벽 반사
            distances.add(distanceSquared(startX, startY, targetX, -targetY));
            // 오른쪽 벽 반사
            distances.add(distanceSquared(startX, startY, 2 * m - targetX, targetY));
            // 왼쪽 벽 반사
            distances.add(distanceSquared(startX, startY, -targetX, targetY));

            // 경로 상에 목표 공이 있는 경우 제외
            if (startX == targetX && startY < targetY) {
                distances.remove((Integer) distanceSquared(startX, startY, targetX, 2 * n - targetY));
            }
            if (startX == targetX && startY > targetY) {
                distances.remove((Integer) distanceSquared(startX, startY, targetX, -targetY));
            }
            if (startY == targetY && startX < targetX) {
                distances.remove((Integer) distanceSquared(startX, startY, 2 * m - targetX, targetY));
            }
            if (startY == targetY && startX > targetX) {
                distances.remove((Integer) distanceSquared(startX, startY, -targetX, targetY));
            }
            
            // 최소 거리 선택
            result[i] = distances.stream().min(Integer::compare).orElse(0);
        }
        
        return result;
    }

    // 거리의 제곱 계산
    private int distanceSquared(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }
}
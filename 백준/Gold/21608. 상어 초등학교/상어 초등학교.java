import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.*;

public class Main {
    static int N;
    static int[][] classroom;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static Map<Integer, Set<Integer>> favoritesMap = new HashMap<>();
    static List<Integer> studentsOrder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classroom = new int[N][N];

        // 학생 순서와 각 학생의 좋아하는 학생 정보 입력 받기
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            studentsOrder.add(student);
            Set<Integer> favorites = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                favorites.add(Integer.parseInt(st.nextToken()));
            }
            favoritesMap.put(student, favorites);
        }

        // 각 학생의 자리를 배치
        for (int student : studentsOrder) {
            assignSeat(student);
        }

        // 만족도 계산
        int totalSatisfaction = calculateSatisfaction();
        System.out.println(totalSatisfaction);
    }

    static void assignSeat(int student) {
        int maxFavoriteCount = -1;
        int maxEmptyCount = -1;
        int chosenX = -1, chosenY = -1;

        // 모든 빈 칸을 순회
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (classroom[x][y] != 0) continue; // 이미 자리가 배치된 곳은 건너뜀

                int favoriteCount = 0;
                int emptyCount = 0;

                // 주변 칸 확인
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    // 좋아하는 학생이 인접한 경우
                    if (favoritesMap.get(student).contains(classroom[nx][ny])) {
                        favoriteCount++;
                    }
                    // 빈 칸인 경우
                    if (classroom[nx][ny] == 0) {
                        emptyCount++;
                    }
                }

                // 조건에 맞는 자리 선택
                if (favoriteCount > maxFavoriteCount ||
                        (favoriteCount == maxFavoriteCount && emptyCount > maxEmptyCount) ||
                        (favoriteCount == maxFavoriteCount && emptyCount == maxEmptyCount && (x < chosenX || (x == chosenX && y < chosenY)))) {
                    maxFavoriteCount = favoriteCount;
                    maxEmptyCount = emptyCount;
                    chosenX = x;
                    chosenY = y;
                }
            }
        }

        // 최종 선택된 자리에 학생 배치
        classroom[chosenX][chosenY] = student;
    }

    static int calculateSatisfaction() {
        int totalSatisfaction = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int student = classroom[x][y];
                int favoriteCount = 0;

                // 인접한 칸의 좋아하는 학생 수를 확인
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if (favoritesMap.get(student).contains(classroom[nx][ny])) {
                        favoriteCount++;
                    }
                }

                // 만족도 계산
                if (favoriteCount == 1) {
                    totalSatisfaction += 1;
                } else if (favoriteCount == 2) {
                    totalSatisfaction += 10;
                } else if (favoriteCount == 3) {
                    totalSatisfaction += 100;
                } else if (favoriteCount == 4) {
                    totalSatisfaction += 1000;
                }
            }
        }

        return totalSatisfaction;
    }
}
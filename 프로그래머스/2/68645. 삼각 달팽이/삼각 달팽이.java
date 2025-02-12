class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n]; // 삼각형 배열
        int[] answer = new int[n * (n + 1) / 2]; // 결과 배열 크기: 1부터 n까지 합
        int num = 1, row = 0, col = 0; // 숫자, 현재 위치(row, col)

        int direction = 0; // 0: 아래, 1: 오른쪽, 2: 위 대각선
        int[] dr = {1, 0, -1}; // 행 이동 방향 (↓, →, ↖)
        int[] dc = {0, 1, -1}; // 열 이동 방향

        while (num <= n * (n + 1) / 2) { // 총 개수만큼 반복
            triangle[row][col] = num++; // 현재 위치에 숫자 삽입
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            // 범위를 벗어나거나 이미 값이 존재하면 방향 변경
            if (nextRow >= n || nextCol >= n || nextRow < 0 || nextCol < 0 || triangle[nextRow][nextCol] != 0) {
                direction = (direction + 1) % 3; // 0 → 1 → 2 순환
                nextRow = row + dr[direction];
                nextCol = col + dc[direction];
            }

            row = nextRow;
            col = nextCol;
        }

        // 2차원 배열을 1차원 배열로 변환
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
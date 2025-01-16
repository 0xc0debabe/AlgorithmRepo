class Solution {
    public int solution(String[] board) {
    int xCnt = 0;
    int oCnt = 0;

    char[][] map = new char[3][3];
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length(); j++) {
            map[i][j] = board[i].charAt(j);
            if (map[i][j] == 'X') {
                xCnt++;
            } else if (map[i][j] == 'O') {
                oCnt++;
            }
        }
    }

    // 턴 차이가 0 또는 1인지 확인
    if (xCnt > oCnt || oCnt - xCnt > 1) {
        return 0;
    }

    // 승리 조건 확인
    int xWinCnt = 0;
    int oWinCnt = 0;

    for (int i = 0; i < 3; i++) {
        // 가로 검사
        if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
            if (map[i][0] == 'X') xWinCnt++;
            if (map[i][0] == 'O') oWinCnt++;
        }

        // 세로 검사
        if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
            if (map[0][i] == 'X') xWinCnt++;
            if (map[0][i] == 'O') oWinCnt++;
        }
    }

    // 대각선 검사
    if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
        if (map[0][0] == 'X') xWinCnt++;
        if (map[0][0] == 'O') oWinCnt++;
    }
    if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
        if (map[0][2] == 'X') xWinCnt++;
        if (map[0][2] == 'O') oWinCnt++;
    }

    // 승리 조건 위반 확인
    if (xWinCnt > 0 && oWinCnt > 0) {
        return 0; // 동시에 두 사람이 승리할 수 없음
    }
    if (oWinCnt > 0 && oCnt != xCnt + 1) {
        return 0; // 'O'가 승리하면 턴 차이가 1이어야 함
    }
    if (xWinCnt > 0 && oCnt != xCnt) {
        return 0; // 'X'가 승리하면 턴 개수가 같아야 함
    }

    return 1; // 규칙에 위배되지 않음
}
}
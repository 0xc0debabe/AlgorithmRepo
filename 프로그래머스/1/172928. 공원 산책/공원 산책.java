

class Solution {
    public static void main(String[] args) {
        String[] s = {"OSO", "OOO", "OXO", "OOO"};
        String[] a = {"E 2", "S 3", "W 1"};
        Solution sol = new Solution();
        sol.solution(s, a);
    }

    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        char[][] map = new char[n][m];
        int nowX = -1;
        int nowY = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    map[i][j] = 'O';
                    nowX = i;
                    nowY = j;
                }
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];
            int dist = Integer.parseInt(split[1]);
            boolean canMove = true;

            if (dir.equals("E")) {
                for (int i = nowY + 1; i <= nowY + dist; i++) {
                    if (i >= m || map[nowX][i] != 'O') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove) nowY = nowY + dist;

            } else if (dir.equals("W")) {
                for (int i = nowY - 1; i >= nowY - dist; i--) {
                    if (i < 0 || map[nowX][i] != 'O') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove) nowY = nowY - dist;

            } else if (dir.equals("N")) {
                for (int i = nowX - 1; i >= nowX - dist; i--) {
                    if (i < 0 || map[i][nowY] != 'O') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove) nowX = nowX - dist;

            } else {
                for (int i = nowX + 1; i <= nowX + dist; i++) {
                    if (i >= n || map[i][nowY] != 'O') {
                        canMove = false;
                        break;
                    }
                }

                if (canMove) nowX = nowX + dist;

            }
        }

        return new int[]{nowX, nowY};
    }

}

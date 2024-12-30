

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = {30, 15};
        int[] ar2 = {26, 17};

        int[] mat = {5, 3, 2};
        String[][] p = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        solution.solution(mat, p);

    }


    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;
        int answer = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i][j].equals("-1")) {
                    answer = Math.max(
                            answer,
                            findPutMat(i, j, park, mats, n, m)
                    );
                }
            }
        }

        return answer;
    }

    private int findPutMat(int row, int col, String[][] park, int[] mats, int n, int m) {
        int tmp = -1;
        for (int mat : mats) {
            if (n < row + mat || m < col + mat) continue;
            boolean flag = false;

            for (int i = row; i < row + mat; i++) {

                for (int j = col; j < col + mat; j++) {
                    if (!park[i][j].equals("-1")) {
                        flag = true;
                        break;
                    }
                }

                if (flag) break;
            }

            if (!flag) tmp = Math.max(tmp, mat);
        }

        return tmp;
    }

}

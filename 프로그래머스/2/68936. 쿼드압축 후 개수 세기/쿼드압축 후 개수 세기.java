class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        sol.solution(arr);
    }


    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return answer;
    }

    private void dfs(int[][] arr, int row, int col, int size) {
        if (size == 0) return;


        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] == 0) zeroCnt++;
                else if (arr[i][j] == 1) oneCnt++;
            }
        }

        if (zeroCnt == size * size){
            answer[0]++;
            return;
        } else if (oneCnt == size * size){
            answer[1]++;
            return;
        }


        int newSize = size / 2;
        dfs(arr, row, col, newSize);
        dfs(arr, row, col + newSize, newSize);
        dfs(arr, row + newSize, col, newSize);
        dfs(arr, row + newSize, col + newSize, newSize);
    }


}
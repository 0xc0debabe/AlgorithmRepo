import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        System.out.println(sol.solution(arr, 2, 2, 3));
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (x, y) ->{
            if (x[col - 1] == y[col - 1]) return y[0] - x[0];
            return x[col - 1] - y[col - 1];
        });

        int[] arr = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int[] d = data[i];
            int sum = 0;
            for (int k : d) sum += k % (i + 1);

            arr[i] = sum;
        }

        int answer = 0;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            answer ^= arr[i];
        }

        return answer;
    }


}
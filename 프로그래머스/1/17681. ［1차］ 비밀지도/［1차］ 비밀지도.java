import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        sol.solution(n, arr1, arr2);
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        char[][] decodeArr = new char[n][n];
        decoded(arr1, decodeArr, n);
        decoded(arr2, decodeArr, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(decodeArr[i][j]);
            }
            if (i != n - 1) sb.append(',');
        }

        return sb.toString().split(",");
    }

    private void decoded(int[] arr, char[][] decodeArr, int n) {
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            String binaryString = Integer.toBinaryString(v);
            StringBuilder sb = new StringBuilder();
            for (int j = binaryString.length(); j < n; j++) {
                sb.append("0");
            }
            String string = sb.append(binaryString).toString();
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == '0' && decodeArr[i][j] != '#') {
                    decodeArr[i][j] = ' ';
                } else {
                    decodeArr[i][j] = '#';
                }
            }
        }
    }

}

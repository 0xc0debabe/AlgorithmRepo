import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }

}

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] arr = {3};
        int[] solution1 = solution.solution(arr);
        for (int i : solution1) {
            System.out.println(i);
        }
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            String fullBinary = getFullBinaryTree(Long.toBinaryString(number));
            boolean divide = divide(fullBinary, 0, fullBinary.length() - 1);
            answer[i] = divide ? 1 : 0;
        }

        return answer;
    }

    private boolean divide(String binary, int left, int right) {
        if (left > right) return true;

        int mid = (left + right) / 2;
        char root = binary.charAt(mid);

        if (root == '0') {
            for (int i = left; i <= right; i++) {
                if (binary.charAt(i) == '1') return false;
            }
        }

        return divide(binary, left, mid - 1) && divide(binary, mid + 1, right);
    }

    private String getFullBinaryTree(String binary) {
        int len = binary.length();
        int level = 1;
        int idx = 1;
        while (level < len) {
            level += (int) Math.pow(2, idx++);
        }
        return "0".repeat(level - len) + binary;
    }

}
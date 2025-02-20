import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {0, 0, 0};
        System.out.println(solution.solution(a));
    }

    public String solution(int[] numbers) {
        String[] array = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (x, y) -> {
            String s1 = x + y;
            String s2 = y + x;
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : array) sb.append(s);

        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

}


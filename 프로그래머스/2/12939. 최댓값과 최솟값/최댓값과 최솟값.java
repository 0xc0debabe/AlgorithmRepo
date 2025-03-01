import java.util.Arrays;


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public String solution(String s) {
        int[] array = Arrays
                .stream(s.split(" "))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .toArray();
        Arrays.sort(array);
        return String.valueOf(array[0]) + " " + String.valueOf(array[array.length - 1]);
    }

}

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {-2, 3, 0, 2, -5};
        sol.solution(arr);
    }

    public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    int i1 = number[i];
                    int i2 = number[j];
                    int i3 = number[k];
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }


}

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(95));
    }

    int answer = 0;
    public int solution(int storey) {
        findMinValue(storey);
        return answer;
    }

    private void findMinValue(int storey) {
        if (storey == 0) return;

        int lastDigit = storey % 10;
        int idx = storey % 100;

        if (lastDigit < 5) {
            answer += lastDigit;
            findMinValue(storey / 10);
        } else if (lastDigit > 5) {
            answer += 10 - lastDigit;
            findMinValue((storey + 10 - lastDigit) / 10);
        } else {
            if (idx / 10 >= 5) {
                answer += 10 - lastDigit;
                findMinValue((storey + 10 - lastDigit) / 10);
            } else {
                answer += lastDigit;
                findMinValue(storey / 10);
            }
        }
    }

}
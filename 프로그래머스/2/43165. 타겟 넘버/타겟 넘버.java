class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        
    }

    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, numbers.length, 0, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int n, int depth, int idx, int sum) {
        if (n == depth) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        
        int plus = numbers[idx];
        int minus = numbers[idx] * -1;
        
        dfs(numbers, target, n, depth + 1, idx + 1, sum + plus);
        dfs(numbers, target, n, depth + 1, idx + 1, sum + minus);
    }

}


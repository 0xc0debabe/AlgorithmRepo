class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] times = {7, 10};
        System.out.println(solution.solution(6, times));
    }

    public long solution(int n, int[] times) {
        long left = 0;
        long right = 1_000_000_000L * 100_000;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long capacity = 0;
            for (int time : times) capacity += mid / time;

//            if (n >= capacity) {
//                answer = mid;
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//
            if (n <= capacity) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

}
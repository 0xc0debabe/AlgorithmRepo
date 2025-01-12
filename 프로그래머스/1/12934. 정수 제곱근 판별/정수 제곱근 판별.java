class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(50000000000000L));
    }

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if ((double) ((int) sqrt) == sqrt) {
            return (long) Math.pow(sqrt + 1, 2);
        }
        return -1;
    }
}

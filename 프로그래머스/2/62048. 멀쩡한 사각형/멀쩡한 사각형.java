class Solution {
    public long solution(int w, int h) {
        long W = (long) w; // int 범위를 초과할 수 있으므로 long 변환
        long H = (long) h;

        return (W * H) - (W + H - gcd(W, H));
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 12)); // Expected output: 80
    }
}
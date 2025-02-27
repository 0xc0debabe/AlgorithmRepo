class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int solution(int[] arr) {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            int gcd = gcd(prev, now);
            prev = lcm(prev, now, gcd);
        }

        return prev;
    }

    private int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
    
    private int gcd(int a,int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

}




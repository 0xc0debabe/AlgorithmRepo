
class Solution {

    public static void main(String[] args) {

    }

    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int gcm = n * m / gcd;
        return new int[]{gcd, gcm};
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}

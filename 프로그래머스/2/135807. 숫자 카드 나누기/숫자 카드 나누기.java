class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {10, 20};
        int[] b = {5, 17};
        System.out.println(sol.solution(a, b));
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = findGcd(arrayA);
        if (isSuccess(arrayB, gcdA)) answer = gcdA;

        int gcdB = findGcd(arrayB);
        if (isSuccess(arrayA, gcdB)) answer = Math.max(answer, gcdB);

        return answer;
    }

    private int findGcd(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) gcd = gcd(gcd, arr[i]);
        return gcd;
    }

    private boolean isSuccess(int[] arr, int gcd) {
        for (int i : arr) if ((i % gcd) == 0) return false;
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
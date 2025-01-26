class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(sol.solution(a));
    }

    public int solution(int[] topping) {
        int n = topping.length;
        int[] left = new int[n];
        int[] right = new int[n];

        boolean[] l = new boolean[10_001];
        boolean[] r = new boolean[10_001];

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left[i] = left[i - 1];
                right[n - 1 - i] = right[n - i];
            }

            if (!l[topping[i]]) {
                l[topping[i]] = true;
                left[i]++;
            }

            if (!r[topping[n - 1 - i]]) {
                r[topping[n - 1 - i]] = true;
                right[n - 1 - i]++;
            }

        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) if (left[i] == right[i + 1]) answer++;

        return answer;
    }

}
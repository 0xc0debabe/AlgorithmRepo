class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strings = {"abce", "abcd", "cdx"};
        sol.solution(strings, 2);
    }

    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length - i - 1; j++) {
                char c1 = strings[j].charAt(n);
                char c2 = strings[j + 1].charAt(n);

                if (c1 > c2) {
                    String tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                } else if (c1 == c2) {
                    if (strings[j].compareTo(strings[j + 1]) > 0) {
                        String tmp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = tmp;
                    }
                }
            }
        }

        return strings;
    }
}

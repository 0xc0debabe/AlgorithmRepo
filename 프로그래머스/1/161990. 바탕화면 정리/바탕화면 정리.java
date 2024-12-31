

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] as = {".#...", "..#..", "...#."};
        sol.solution(as);
    }

    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = -1;
        int rdy = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            String paper = wallpaper[i];

            for (int j = 0; j < paper.length(); j++) {
                char c = paper.charAt(j);
                if (c == '#') {
                    lux = Math.min(lux, j);
                    luy = Math.min(i, luy);
                    rdx = Math.max(rdx, j);
                    rdy = Math.max(i, rdy);
                }
            }
        }

        return new int[]{luy, lux, rdy + 1, rdx + 1};
    }

}

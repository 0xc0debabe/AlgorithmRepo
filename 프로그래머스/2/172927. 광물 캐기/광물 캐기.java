class Solution {
    private int minFatigue = Integer.MAX_VALUE;
    private final int[][] fatigue = {
        {1, 1, 1}, // Diamond pickaxe
        {5, 1, 1}, // Iron pickaxe
        {25, 5, 1} // Stone pickaxe
    };

    public int solution(int[] picks, String[] minerals) {
        backtrack(picks, minerals, 0, 0);
        return minFatigue;
    }

    private void backtrack(int[] picks, String[] minerals, int index, int currentFatigue) {
        // 종료 조건: 더 이상 곡괭이를 사용할 수 없거나 광물을 모두 캤을 때
        if (index >= minerals.length || allPicksUsed(picks)) {
            minFatigue = Math.min(minFatigue, currentFatigue);
            return;
        }

        // 곡괭이를 하나씩 사용해본다
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                picks[i]--; // 곡괭이 사용
                int fatigueForThisPick = calculateFatigue(i, minerals, index);
                backtrack(picks, minerals, index + 5, currentFatigue + fatigueForThisPick);
                picks[i]++; // 백트래킹을 위해 복원
            }
        }
    }

    private boolean allPicksUsed(int[] picks) {
        for (int pick : picks) {
            if (pick > 0) return false;
        }
        return true;
    }

    private int calculateFatigue(int pickType, String[] minerals, int startIndex) {
        int fatigueSum = 0;
        for (int i = startIndex; i < Math.min(startIndex + 5, minerals.length); i++) {
            String mineral = minerals[i];
            int mineralType = getMineralType(mineral);
            fatigueSum += fatigue[pickType][mineralType];
        }
        return fatigueSum;
    }

    private int getMineralType(String mineral) {
        switch (mineral) {
            case "diamond": return 0;
            case "iron": return 1;
            case "stone": return 2;
        }
        return -1; // Should not reach here
    }
}
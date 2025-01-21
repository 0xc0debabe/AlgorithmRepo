class Solution {
    private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    private int maxSubscribers = 0;
    private int maxRevenue = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        dfs(users, emoticons, discounts, 0);
        return new int[]{maxSubscribers, maxRevenue};
    }

    private void dfs(int[][] users, int[] emoticons, int[] discounts, int depth) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, discounts);
            return;
        }

        for (int discount : DISCOUNT_RATES) {
            discounts[depth] = discount;
            dfs(users, emoticons, discounts, depth + 1);
        }
    }

    private void calculate(int[][] users, int[] emoticons, int[] discounts) {
        int subscribers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int userDiscountThreshold = user[0];
            int userPriceThreshold = user[1];
            int totalCost = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userDiscountThreshold) {
                    totalCost += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            if (totalCost >= userPriceThreshold) {
                subscribers++;
            } else {
                revenue += totalCost;
            }
        }

        if (subscribers > maxSubscribers || (subscribers == maxSubscribers && revenue > maxRevenue)) {
            maxSubscribers = subscribers;
            maxRevenue = revenue;
        }
    }
}
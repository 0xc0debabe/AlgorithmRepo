class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(3, 20, 4);
    }

    public long solution(int price, int money, int count) {
        int p = price;
        long totalPrice = 0;
        while(count-- > 0) {
            totalPrice += price;
            price = price + p;
        }

        long answer = totalPrice - money;
        return answer < 0 ? 0 : answer;
    }

}

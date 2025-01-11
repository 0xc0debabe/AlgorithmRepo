
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public boolean solution(int x) {
        int digitSum = 0;
        int tmp = x;
        while (x > 0) {
            digitSum += x % 10;
            x /=10;
        }
        if (tmp % digitSum == 0) {
            return true;
        } else {
            return false;
        } 
    }

}

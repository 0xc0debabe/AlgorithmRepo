class Solution {
    public int solution(int num1, int num2) {
        double d1 = (double) num1;
        double d2 = (double) num2;
        double a = d1 / d2 * 1000;
        System.out.println((int) a);
        return (int) a;
    }
}
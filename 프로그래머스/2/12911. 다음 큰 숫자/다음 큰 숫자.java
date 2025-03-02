
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int solution(int n) {
        int zeroCnt = getOneCnt(convertToBinary(n));
        int answer = 0;

        for (int i = n + 1; i <= 1_000_000; i++) {
            if (findNextNum(i, zeroCnt)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    private boolean findNextNum(int i, int oneCount) {
        int oneCnt = getOneCnt(convertToBinary(i));
        return oneCnt == oneCount;
    }

    private int getOneCnt(String binary) {
        int cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '1') cnt++;
        }

        return cnt;
    }

    private String convertToBinary(int num) {
        return Integer.toBinaryString(num);
    }



}
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1]; // 각 수의 약수 개수 저장

        // 1 ~ e까지 약수 개수 구하기
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }

        int[] maxCountArr = new int[e + 1]; // i 이상에서 가장 많이 등장한 수
        int maxNum = e;
        maxCountArr[e] = e;

        for (int i = e - 1; i >= 1; i--) {
            if (count[i] >= count[maxNum]) {
                maxNum = i;
            }
            maxCountArr[i] = maxNum;
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxCountArr[starts[i]];
        }

        return answer;
    }
}
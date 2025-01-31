class Solution {
    public static void main(String[] args) {
        int[] ele = {1,3,5};
        Solution solution = new Solution();
        System.out.println(solution.solution(ele));
    }

    public int solution(int[] elements) {
        boolean[] isVisited = new boolean[1_000_001];
        int[] newArr = new int[elements.length * 2];
        for (int i = 0; i < newArr.length; i++) newArr[i] = elements[i % elements.length];

        int pointer = 0;
        int idx = 1;
        int answer = 0;

        for (int i = 0; i < elements.length; i++) {

            while (pointer < elements.length) {
                int sum = 0;
                for (int j = 0; j < idx; j++) sum += newArr[j + pointer];

                if (!isVisited[sum]) {
                    isVisited[sum] = true;
                    answer++;
                }

                pointer++;
            }

            idx++;
            pointer = 0;
        }

        return answer;
    }

}
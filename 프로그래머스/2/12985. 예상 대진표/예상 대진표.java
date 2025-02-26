import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 1, 8));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;

        while (n > 0) {
            answer++;

            if (a % 2 == 0) {
                if (a - 1 == b) {
                    break;
                }
            } else {
                if (a + 1 == b) {
                    break;
                }
            }

            if (a % 2 == 1) {
                a++;
            }

            if (b % 2 == 1) {
                b++;
            }

            a /= 2;
            b /= 2;

            n /= 2;
        }

        return answer;
    }

}





import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String a = "17";
        System.out.println(sol.solution(a));
    }

    boolean[] isPrime = new boolean[10_000_000];
    boolean[] isVisited;
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < 10_000_000; i++) {

            if (isPrime[i]) {
                for (int j = i * i; j < 10_000_000; j += i) {
                    isPrime[j] = false;
                }
            }

        }

        char[] charArray = numbers.toCharArray();
        isVisited = new boolean[charArray.length];
        dfs(charArray, new StringBuilder(), 0);

        return set.size();
    }

    private void dfs(char[] charArr, StringBuilder concat, int depth) {
        if (depth == charArr.length) {
            return;
        }

        for (int i = 0; i < charArr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;

                concat.append(charArr[i]);
                int target = Integer.parseInt(concat.toString());
                if (isPrime[target]) {
                    set.add(target);
                }

                dfs(charArr, concat, depth + 1);
                
                isVisited[i] = false;
                concat.deleteCharAt(concat.length() - 1);
            }
        }

    }

}
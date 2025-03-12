import java.util.*;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] ref = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] result = solution.solution(enroll, ref, seller, amount);
        for (int i : result) {
            System.out.println(i);
        }
    }

    Map<String, String> link = new HashMap<>();
    Map<String, Integer> money = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            String enr = enroll[i];
            String ref = referral[i];
            link.put(enr, ref);
        }

        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            if (money.containsKey(enroll[i])) {
                answer[i] = money.get(enroll[i]);
            }
        }

        return answer;
    }


    private void dfs(String name, int salePrice) {
        if (salePrice <= 0 || name == null) return;
        int nextBenefit = salePrice / 10;
        money.put(name, money.getOrDefault(name, 0) + salePrice - nextBenefit);

        if (nextBenefit > 0 && link.containsKey(name)) {
            dfs(link.get(name), nextBenefit);
        }
    }

}
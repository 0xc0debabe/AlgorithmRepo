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

    List<List<String>> list = new ArrayList<>();
    Map<String, Integer> converter = new HashMap<>();
    int[] result;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i <= enroll.length; i++) {
            list.add(new ArrayList<>());
        }

        converter.put("center", 0);
        for (int i = 1; i <= enroll.length; i++) {
            converter.put(enroll[i - 1], i);
        }

        for (int i = 0; i < enroll.length; i++) {
            String enr = enroll[i];
            String ref = referral[i];

            if (ref.equals("-")) {
                list.get(converter.get(enr)).add("center");
                continue;
            }

            list.get(converter.get(enr)).add(ref);
        }

        result = new int[enroll.length + 1];
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            dfs(s, amount[i] * 100);
        }

        return Arrays.copyOfRange(result, 1, result.length);
    }

    private void dfs(String name, int salePrice) {
        if (salePrice < 1) return;
        int myBenefit = (int) Math.ceil(salePrice * 0.9);
        int rest = (int) (salePrice * 0.1);
        result[converter.get(name)] += myBenefit;

        for (String next : list.get(converter.get(name))) {
            dfs(next, rest);
        }
    }

}
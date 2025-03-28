import java.util.*;
import java.io.*;

// Math.pow를 사용하면 부동소수점 연산으로 인한 오버헤드가 발생할 수 있으므로,
// 반복문과 정수 연산을 이용하여 26진법 변환을 수행합니다.

class Solution {

    public static void main(String[] args) {
        String[] beans = {"d", "e", "bb", "aa", "ae"};
        Solution solution = new Solution();
        solution.solution(30, beans);
    }

    public String solution(long n, String[] bans) {
        // banned 주문들을 길이, 사전순으로 정렬
        Queue<String> bansQueue = new ArrayDeque<>();
        Arrays.sort(bans, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        for (int i = 0; i < bans.length; i++) {
            bansQueue.add(bans[i]);
        }

        // banned 주문들보다 순서가 앞에 있는 주문이 있으면 n을 증가시킴.
        // 조건: banned 주문의 길이가 현재 n번째 주문(getString(n))보다 짧거나,
        //       길이가 같을 경우 사전순으로 같거나 앞서 있으면.
        while (!bansQueue.isEmpty()) {
            String cur = bansQueue.peek();
            String target = getString(n);
            if (cur.length() < target.length() || (cur.length() == target.length() && cur.compareTo(target) <= 0)) {
                bansQueue.poll();
                n++;
            } else {
                break;
            }
        }
        return getString(n);
    }

    // getString: 숫자 n을 주문서의 순서에 맞는 문자열로 변환
    // 변환 방식: 26진법 변환과 유사하게 처리하며, n이 26의 배수인 경우를 따로 처리함.
    private String getString(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            long remained = n % 26;
            n /= 26;
            if (remained == 0) {
                n--;
                sb.append('z');
            } else {
                sb.append((char)('a' + remained - 1));
            }
        }
        return sb.reverse().toString();
    }
}
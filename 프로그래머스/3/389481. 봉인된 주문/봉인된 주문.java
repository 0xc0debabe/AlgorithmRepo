import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] beans = {};
        Solution solution = new Solution();
        System.out.println(solution.solution(52, beans));
    }

    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (x, y) -> {
            if (x.length() == y.length()) {
                return x.compareTo(y);
            }
            return x.length() - y.length();
        });

        Queue<String> queue = new LinkedList<>(Arrays.asList(bans));

        while (!queue.isEmpty()) {
            String ban = queue.peek();
            String nowStr = convertToStr(n);

            if (nowStr.length() > ban.length() ||
                    (nowStr.length() == ban.length() && nowStr.compareTo(ban) >= 0)) {
                n++;
                queue.poll();
            } else {
                break;
            }
        }

        return convertToStr(n);
    }

    private String convertToStr(long n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            long reminder = (n - 1) % 26;
            sb.append((char) ('a' + reminder));
            n /= 26;
            if (reminder == 25) n--;
        }

        return sb.reverse().toString();
    }

}
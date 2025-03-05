import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가능
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> depth = new HashMap<>();

        queue.add(begin);
        depth.put(begin, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDepth = depth.get(current);

            for (String word : words) {
                if (!depth.containsKey(word) && isOneLetterDiff(current, word)) {
                    depth.put(word, currentDepth + 1);
                    queue.add(word);
                    
                    // target을 찾으면 변환 횟수 반환
                    if (word.equals(target)) return currentDepth + 1;
                }
            }
        }

        return 0;  // 변환할 수 없는 경우
    }

    // 단어 두 개가 한 글자만 다른지 확인
    private boolean isOneLetterDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;  // 2개 이상 다르면 false
        }
        return diff == 1;  // 정확히 1개만 다를 때 true
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> countMap = new HashMap<>();
        
        // 1. 각 주문을 알파벳 순으로 정렬 후 조합을 구함
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);
            
            // 2. 각 주문에서 가능한 조합을 찾음
            for (int c : course) {
                if (c <= sortedOrder.length()) {
                    generateCombinations(sortedOrder, c, 0, "", countMap);
                }
            }
        }

        // 3. 코스 개수별 최다 주문된 조합 찾기
        List<String> result = new ArrayList<>();
        for (int c : course) {
            int maxCount = 2; // 최소 2명 이상이 주문해야 함
            List<String> candidates = new ArrayList<>();
            
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getKey().length() == c) {
                    int count = entry.getValue();
                    if (count > maxCount) {
                        maxCount = count;
                        candidates.clear();
                        candidates.add(entry.getKey());
                    } else if (count == maxCount) {
                        candidates.add(entry.getKey());
                    }
                }
            }
            
            result.addAll(candidates);
        }

        // 4. 사전 순 정렬 후 반환
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    // 조합을 생성하여 countMap에 저장하는 함수
    private void generateCombinations(String order, int len, int index, String current, Map<String, Integer> countMap) {
        if (current.length() == len) {
            countMap.put(current, countMap.getOrDefault(current, 0) + 1);
            return;
        }
        for (int i = index; i < order.length(); i++) {
            generateCombinations(order, len, i + 1, current + order.charAt(i), countMap);
        }
    }
}
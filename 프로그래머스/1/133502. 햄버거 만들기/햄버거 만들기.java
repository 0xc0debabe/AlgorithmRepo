import java.util.Stack;

public class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int burgerCount = 0;
        
        // 햄버거의 재료 순서: 빵(1) - 야채(2) - 고기(3) - 빵(1)
        for (int ing : ingredient) {
            stack.push(ing);
            
            // 스택에 최소 4개의 재료가 있어야 햄버거를 검사 가능
            if (stack.size() >= 4) {
                int size = stack.size();
                
                // 위에서부터 햄버거 재료가 맞는지 확인
                if (stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                    
                    // 햄버거 재료를 스택에서 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    // 햄버거 개수 증가
                    burgerCount++;
                }
            }
        }
        
        return burgerCount;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        
        System.out.println(solution.solution(ingredient1)); // 출력: 2
        System.out.println(solution.solution(ingredient2)); // 출력: 0
    }
}
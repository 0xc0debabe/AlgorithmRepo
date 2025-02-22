import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"123", "1006", "1005", "1007"};
        System.out.println(solution.solution(arr));
    }

    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;
        
        return true;
    }

}


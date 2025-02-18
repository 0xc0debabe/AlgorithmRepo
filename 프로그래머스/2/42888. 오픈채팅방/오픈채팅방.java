import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] solution1 = solution.solution(s);
        for (String sdf : solution1) {
            System.out.println(sdf);
        }
    }

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (String r : record) {
            String[] split = r.split(" ");
            if (split.length == 3) {
                map.put(split[1], split[2]);
            }
        }

        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        List<String> list = new ArrayList<>();
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[0].equals("Enter")) {
                list.add(map.get(split[1]) + enter);
            } else if (split[0].equals("Leave")) {
                list.add(map.get(split[1]) + leave);
            }
        }

        return list.toArray(String[]::new);
    }

}


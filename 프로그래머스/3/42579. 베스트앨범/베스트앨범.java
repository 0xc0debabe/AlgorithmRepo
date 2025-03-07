import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] s = {"classic", "pop", "classic", "classic", "pop"};
        int[] a = {500, 600, 150, 800, 600};
        Solution asdf = new Solution();
        int[] solution = asdf.solution(s, a);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlaysMap = new HashMap<>();
        Map<String, List<int[]>> genresMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            totalPlaysMap.put(genre, totalPlaysMap.getOrDefault(genre, 0) + plays[i]);

            List<int[]> list;
            if (genresMap.containsKey(genre)) list = genresMap.get(genre);
            else list = new ArrayList<>();

            list.add(new int[]{i, plays[i]});
            genresMap.put(genre, list);
        }

        List<String> keySet = new ArrayList<>(totalPlaysMap.keySet());
        keySet.sort((k1, k2) -> totalPlaysMap.get(k2) - totalPlaysMap.get(k1));
        List<Integer> answer = new ArrayList<>();
        for (String key : keySet) {
            List<int[]> list = genresMap.get(key);
            list.sort((x, y) -> y[1] - x[1]);

            for (int i = 0; i < Math.min(2, list.size()); i++) {
                int[] music = list.get(i);
                answer.add(music[0]);
            }

        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
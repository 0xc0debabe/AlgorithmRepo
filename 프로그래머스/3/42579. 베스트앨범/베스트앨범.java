
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] s = {"classic", "pop", "classic", "classic", "pop"};
        int[] a = {500, 600, 150, 800, 2500};
        Solution asdf = new Solution();
        asdf.solution(s, a);
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Node>> nodeMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
            if (!nodeMap.containsKey(genre)) {
                nodeMap.put(genre, new ArrayList<>());
            }
            nodeMap.get(genre).add(new Node(i, play));
        }
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted((y, x) -> x.getValue() - y.getValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> x,
                        LinkedHashMap::new
                ));
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            List<Node> nodes = nodeMap.get(entry.getKey());
            Collections.sort(nodes);
            for (int i = 0; i < Math.min(2, nodes.size()); i++) {
                answer.add(nodes.get(i).idx);
            }
        }

        int[] realAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            realAnswer[i] = answer.get(i);
        }

        return realAnswer;
    }

    static class Node implements Comparable<Node>{
        int idx;
        int play;

        public Node(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Node o) {
            if (o.play == this.play) {
                return this.idx - o.idx;
            }
            return o.play - this.play;
        }
    }


}

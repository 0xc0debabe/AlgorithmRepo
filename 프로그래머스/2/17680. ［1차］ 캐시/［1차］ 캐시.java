import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] city = {"a", "a"};
        System.out.println(solution.solution(2, city));
    }

    public int solution(int cacheSize, String[] cities) {
        PriorityQueue<Cache> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            city = city.toLowerCase();

            Iterator<Cache> iterator = pq.iterator();
            boolean flag = true;

            while (iterator.hasNext()) {
                Cache next = iterator.next();
                if (next.city.equals(city)) {
                    iterator.remove();
                    pq.add(new Cache(city, i));
                    flag = false;
                    answer += 1;
                    break;
                }
            }

            if (flag) {
                answer += 5;
                pq.add(new Cache(city, i));
            }

            if (pq.size() > cacheSize) {
                pq.poll();
            }
        }

        return answer;
    }

    static class Cache implements Comparable<Cache>{
        private String city;
        private int priority;

        public Cache(String city, int priority) {
            this.city = city;
            this.priority = priority;
        }

        public int compareTo(Cache cache) {
            return this.priority - cache.priority;
        }
    }

}




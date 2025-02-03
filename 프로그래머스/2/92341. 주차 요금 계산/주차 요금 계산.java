import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {120, 0, 60, 591};
        String[] b = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        int[] arr = sol.solution(a, b);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> resMap = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNumber = split[1];
            String history = split[2];

            if (history.equals("IN")) {
                map.put(carNumber, time);
            } else {
                String inTime = map.get(carNumber);
                int diff = diff(inTime, time);
                map.remove(carNumber);
                resMap.put(carNumber, resMap.getOrDefault(carNumber, 0) + diff);
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String carNumber = entry.getKey();
            String outTime = "23:59";
            String inTime = entry.getValue();
            int diff = diff(inTime, outTime);
            resMap.put(carNumber, resMap.getOrDefault(carNumber, 0) + diff);
        }

        List<Fee> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
            int totalTime = entry.getValue();
            int totalFee;
            if (totalTime > defaultTime) totalFee = cal(defaultFee, totalTime, defaultTime, unitTime, unitFee);else totalFee = defaultFee;
            list.add(new Fee(entry.getKey(), totalFee));
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(i -> i.totalFee).toArray();
    }

    private int diff(String inTime, String outTime) {
        int inMinute = timeToMinute(inTime);
        int outMinute = timeToMinute(outTime);
        return outMinute - inMinute;
    }

    private int timeToMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hour * 60 + min;
    }

    private int cal(
            int defaultFee,
            int totalTime,
            int defaultTime,
            int unitTime,
            int unitFee) {

        int feePerTime = (totalTime - defaultTime) / unitTime;
        if ((totalTime - defaultTime) % unitTime != 0) feePerTime++;

        return defaultFee + feePerTime * unitFee;
    }

    static class Fee implements Comparable<Fee>{
        String carNumber;
        int totalFee;

        public Fee(String carNumber, int totalFee) {
            this.carNumber = carNumber;
            this.totalFee = totalFee;
        }

        @Override
        public int compareTo(Fee o) {
            return this.carNumber.compareTo(o.carNumber);
        }
    }
}

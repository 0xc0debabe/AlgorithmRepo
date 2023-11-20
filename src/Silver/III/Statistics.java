package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round(((double)sum / (double)n)));

        int[] arr2 = new int[n];
        System.arraycopy(arr, 0, arr2, 0, n);
        Arrays.sort(arr2);
        System.out.println(arr2[n/2]);


        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        int mapMax = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (mapMax < entry.getValue()) {
                mapMax = entry.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < mapMax) {
                map.remove(entry.getKey());
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        if (map.size() == 1) {
            System.out.println(keys.get(0));
        } else {
            Collections.sort(keys);
            System.out.println(keys.get(1));
        }

        int max = -4001;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int min = 4001;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(max - min);

    }
}

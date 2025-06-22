import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 우주의 개수
        int N = Integer.parseInt(st.nextToken()); // 행성의 개수

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 좌표 압축
            int[] ranked = rankCompress(arr);
            // 배열을 문자열로 변환
            String key = Arrays.toString(ranked);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        // 쌍의 개수 세기 (nC2)
        long result = 0;
        for (int count : freq.values()) {
            if (count > 1) {
                result += (long) count * (count - 1) / 2;
            }
        }

        System.out.println(result);
    }

    private static int[] rankCompress(int[] arr) {
        int N = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
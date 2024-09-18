import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][3];
        for (int i  = 0; i  < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        while (time <= 100) {
            if (r - 1 < arr.length && c - 1 < arr[0].length && arr[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }
            arr = sol(arr);
            time++;
        }

        System.out.println(-1);
    }

    static int[][] sol(int[][] arr) {
        List<List<Node>> lists = new ArrayList<>();
        int max = 0;

        if (arr.length >= arr[0].length) { // R연산
            for (int i = 0; i < arr.length; i++) {
                Map<Integer, Integer> map = new HashMap<>();

                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) continue;
                    map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                }

                max = Math.max(max, map.size() * 2);
                lists.add(new ArrayList<>());
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    lists.get(i).add(new Node(key, value));
                }
                lists.get(i).sort((x, y) -> {
                    if (x.v == y.v) {
                        return x.k - y.k;
                    }
                    return x.v - y.v;
                });
            }

            max = Math.min(max, 100); // 최대 크기 제한
            int[][] newArr = new int[arr.length][max];
            for (int i = 0; i < lists.size(); i++) {
                int idx = 0;
                for (int j = 0; j < lists.get(i).size(); j++) {
                    if (idx >= 100) break; // 100개의 요소까지만 처리
                    Node node = lists.get(i).get(j);
                    newArr[i][idx++] = node.k;
                    newArr[i][idx++] = node.v;
                }
            }

            return newArr;
        } else { // C연산
            for (int i = 0; i < arr[0].length; i++) {
                Map<Integer, Integer> map = new HashMap<>();

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][i] == 0) continue;
                    map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
                }

                max = Math.max(max, map.size() * 2);
                lists.add(new ArrayList<>());
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    lists.get(i).add(new Node(key, value));
                }

                lists.get(i).sort((x, y) -> {
                    if (x.v == y.v) {
                        return x.k - y.k;
                    }
                    return x.v - y.v;
                });
            }

            max = Math.min(max, 100); // 최대 크기 제한
            int[][] newArr = new int[max][arr[0].length];
            for (int i = 0; i < lists.size(); i++) {
                int idx = 0;
                for (int j = 0; j < lists.get(i).size(); j++) {
                    if (idx >= 100) break; // 100개의 요소까지만 처리
                    Node node = lists.get(i).get(j);
                    newArr[idx++][i] = node.k;
                    newArr[idx++][i] = node.v;
                }
            }

            return newArr;
        }
    }

}

class Node {
    int k;
    int v;

    public Node(int k, int v) {
        this.k = k;
        this.v = v;
    }
}
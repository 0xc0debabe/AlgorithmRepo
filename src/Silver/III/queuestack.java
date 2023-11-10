package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] queueorstackarr = new int[n];
        int[] answer = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queueorstackarr[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(stk.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int saveNum = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < queueorstackarr.length; j++) {
                if (queueorstackarr[j] == 0) {
                    deque.add(saveNum);
                    saveNum = deque.pop();
                    answer[i] = saveNum;
                }
                else {
                    answer[i] = deque.peekFirst();
                    deque.add(deque.pop());
                }
            }
        }

        for (int i = 0; i < m-1; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.print(answer[m-1]);
    }
}

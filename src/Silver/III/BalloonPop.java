package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BalloonPop {
    static Deque<int[]> deque = new ArrayDeque<>();

    static Deque change() { // 부호가 바뀔경우, 배열의 순서를 뒤집음
        Deque<int[]> tmp = new ArrayDeque<>();
        int dequeSize = deque.size();
        for (int i = 0; i < dequeSize; i++) {
            tmp.add(deque.poll());
        }

        int tmpSize = tmp.size();
        for (int i = 0; i < tmpSize; i++) {
            deque.add(tmp.pollLast());
        }
        return deque;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            deque.add(new int[]{i + 1, Integer.parseInt(stk.nextToken())});
        }

        boolean needChange = false;
        boolean prevSign = true; // 양수일 때, +
        if (deque.peek()[1] < 0) {
            needChange = true;
            prevSign = false; // 음수일 때, -
        }

        while (!deque.isEmpty()) {
                if ((deque.peek()[1] > 0 && !prevSign) || ((deque.peek()[1] < 0) && prevSign)) { // 이전의 부호와 현재의 부호가 다른지 판단
                    needChange = true;
                }
            if (deque.peek()[1] > 0) {
                prevSign = true;
            } else prevSign = false;

            int peek = Math.abs(deque.peek()[1]); // for문 반복할 때, 음수일 경우도 있기 때문에 절댓값처리
            sb.append(deque.peek()[0]).append(" ");
            deque.poll(); // 시작을 poll로 한 이후, 아래 for문 반복을 한 번 뺌. 뺀 이유는 change 메소드에서 바뀌는 배열은 바뀌지 않아야하기 때문
            if (needChange) {
                change();
                needChange = false;
            }
            if (deque.size() > 0) { // deque의 마지막 순번일 때, 위의 시작 poll에서 빼기 때문에 deque는 존재하지 않음. 조건 추가하지 않으면 null예외뜸
                for (int i = 0; i < peek - 1; i++) {
                    deque.add(deque.poll());
                }
            }
        }
        System.out.println(sb);
    }
}
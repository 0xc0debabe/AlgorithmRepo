import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 중앙값을 빠르게 찾기 위한 두 개의 우선순위 큐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 중앙값 이하의 값들
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중앙값 이상의 값들

        // K개의 값을 먼저 삽입하여 첫 번째 중앙값 찾기
        for (int i = 0; i < K; i++) {
            addNumber(arr[i], maxHeap, minHeap);
        }

        long sum = getMedian(maxHeap, minHeap); // 첫 번째 중앙값

        for (int i = K; i < N; i++) {
            // 새로운 값을 추가하고
            addNumber(arr[i], maxHeap, minHeap);
            // 윈도우에서 제외할 값을 제거한다
            removeNumber(arr[i - K], maxHeap, minHeap);
            // 중앙값을 구해서 더한다
            sum += getMedian(maxHeap, minHeap);
        }

        System.out.println(sum);
    }

    // 새로운 숫자를 추가하는 함수
    private static void addNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        balanceHeaps(maxHeap, minHeap);
    }

    // 윈도우에서 빠지는 숫자를 제거하는 함수
    private static void removeNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        balanceHeaps(maxHeap, minHeap);
    }

    // 두 힙의 크기를 균형 맞추는 함수
    private static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // 현재 중앙값을 반환하는 함수
    private static int getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        return maxHeap.peek();
    }
}
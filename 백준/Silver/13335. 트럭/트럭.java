import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int truckNum = Integer.parseInt(st.nextToken());
        int bridgeLength = Integer.parseInt(st.nextToken());
        int bridgeWeight = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> truckWeight = new LinkedList<>();
        for (int i = 0; i < truckNum; i++) {
            truckWeight.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }
        int currBridgeWeight = 0;
        int time = 0;

        while (!bridge.isEmpty()) {
            time++;
            currBridgeWeight -= bridge.poll();
            if (!truckWeight.isEmpty()) {

                if (currBridgeWeight + truckWeight.peek() <= bridgeWeight) {
                    int truck = truckWeight.poll();
                    currBridgeWeight += truck;
                    bridge.add(truck);
                } else {
                    bridge.add(0);
                }

            }

        }

        System.out.println(time);
    }
}

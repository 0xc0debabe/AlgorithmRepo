import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i * i < 10001; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < 10001; j += i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i < 10001; i++) {
            if (isPrime[i]) primeList.add(i);
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            int diffMin = Integer.MAX_VALUE;
            int prime1 = 0;
            int prime2 = 0;

            for (int j = 0; j < primeList.size(); j++) {
                for (int k = j; k < primeList.size(); k++) {
                    int p1 = primeList.get(j);
                    int p2 = primeList.get(k);

                    if (p1 + p2 > num) break;
                    if (p1 + p2 != num) continue;

                    if (diffMin > Math.abs(p1 - p2)) {
                        diffMin = Math.abs(p1 - p2);
                        prime1 = p1;
                        prime2 = p2;
                    }
                }
            }

//            for (int p1 : primeList) {
//                for (int p2 : primeList) {
//                    if (p1 + p2 > num) break;
//                    if (p1 + p2 != num) continue;
//
//                    if (diffMin > Math.abs(p1 - p2)) {
//                        diffMin = Math.abs(p1 - p2);
//                        prime1 = p1;
//                        prime2 = p2;
//                    }
//                }
//            }

            sb.append(prime1).append(" ").append(prime2).append("\n");
        }

        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Doll[] dolls = new Doll[n];
        for(int i = 0; i < n; i++) {
            dolls[i] = new Doll(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(dolls);
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i + k < n; i++) {
            if (dolls[i].value != 1 || dolls[i + k - 1].value != 1) break;
            answer = Math.min(answer, dolls[i + (k - 1)].idx - dolls[i].idx + 1);
        }

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    static class Doll implements Comparable<Doll>{
        int value;
        int idx;

        public Doll(int v, int i) {
            this.value = v;
            this.idx = i;
        }

        public int compareTo(Doll d) {
            if(this.value == d.value) {
                return this.idx - d.idx;
            }

            return this.value - d.value;
        }
    }
}
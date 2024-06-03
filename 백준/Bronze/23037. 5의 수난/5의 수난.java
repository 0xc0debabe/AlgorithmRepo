import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int[] blank = new int[split.length];
        for (int i = 0; i < blank.length; i++) {
            blank[i] = (int) Math.pow(Integer.parseInt(split[i]), 5);
        }
        System.out.println(Arrays.stream(blank).sum());
    }
}
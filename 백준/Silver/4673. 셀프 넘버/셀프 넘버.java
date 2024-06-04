import java.io.IOException;

public class Main {
    static boolean[] isVisited = new boolean[100001];

    public static void main(String[] args) throws IOException{
        for (int i = 1; i <= 10000; i++) {
            recursion(i, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!isVisited[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    public static void recursion(int n, int sum) {
        if (n == 0){
            isVisited[sum] = true;
            return;
        }
        sum += n % 10;
        recursion(n / 10, sum);
    }
}
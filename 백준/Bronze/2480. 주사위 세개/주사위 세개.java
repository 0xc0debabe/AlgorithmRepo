import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int result = 0;

        if( a == b && b == c){
            result = 10000 + a * 1000;
        }

        if ((a == b && b != c)){
            result = 1000 + a * 100;
        }
        if ((a == c && a != b)) {
            result = 1000 + a * 100;
        }
        if ((b == c && a != b)) {
            result = 1000 + b * 100;
        }

        if((a != b && a != c && b != c)){
            if ( a > b && a > c){
                result = a * 100;
            } else if (b > a && b > c) {
                result = b * 100;
            } else if (c > a && c > b){
                result = c * 100;
            }
        }
        System.out.println(result);
    }
}
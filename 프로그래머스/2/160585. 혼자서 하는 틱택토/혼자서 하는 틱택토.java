import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s1 = {
                "O.X",
                "O.X",
                "O.."
        };// 1

        String[] s2 = {
                "OOX",
                "OOX",
                "XXO"
        };// 1

        String[] s3 = {
                "XOX",
                "OXO",
                "XOO"
        };// 0

        String[] s4 = {
                "O.X",
                "O..",
                "O.."
        };// 0

        String[] s5 = {
                "OOO",
                "...",
                "XXX"
        };// 0

        String[] s6 = {
                "XO.",
                "OXO",
                "XOX"
        };// 1

        String[] s7 = {
                "OOO",
                "XOX",
                "XXO"
        };// 1

        String[] s8 = {
                "XOX",
                "OXO",
                "XOX"};// 0

        String[] s9 = {
                "OXO",
                "XOX",
                "OXO"};// 1
//        System.out.println(sol.solution(s1));// 1
//        System.out.println(sol.solution(s2));// 1
//        System.out.println(sol.solution(s3));// 0
//        System.out.println(sol.solution(s4));// 0
//        System.out.println(sol.solution(s5));// 0
//        System.out.println(sol.solution(s6));// 1
        System.out.println(sol.solution(s7));// 1
//        System.out.println(sol.solution(s8));// 0
//        System.out.println(sol.solution(s9));// 1
    }

    public int solution(String[] board) {
        int Ocnt = 0;
        int Xcnt = 0;
        //O와 X의 개수를 센다.
        for (int i = 0; i < 3; i++) {
            Ocnt += countChar(board[i], 'O');
            Xcnt += countChar(board[i], 'X');
        }

        //'X'가 'O'보다 많으면 규칙 위반
        if (Xcnt > Ocnt) {
            return 0;
        }

        //'O'가 'X'보다 2개이상 많으면 규칙 위반
        if (Ocnt > Xcnt + 1) {
            return 0;
        }

        //O가 완성 되었을 때 X가 O의 개수와 같으면 규칙 위반
        if (hasWin(board, 'O')) {
            if (Ocnt == Xcnt) {
                return 0;
            }
        }
        //X가 완성 되었을 때 O가 X보다 1개 많으면 규칙 위반
        if (hasWin(board, 'X')) {
            if (Ocnt == Xcnt + 1) {
                return 0;
            }
        }
        return 1;
    }

    private static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    private static boolean hasWin(String[] board, char ch) {
        //가로 검사
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch
                    && board[i].charAt(1) == ch
                    && board[i].charAt(2) == ch) {
                return true;
            }
        }
        //세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == ch
                    && board[1].charAt(i) == ch
                    && board[2].charAt(i) == ch) {
                return true;
            }
        }
        //대각선 검사
        if (board[0].charAt(0) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }


}
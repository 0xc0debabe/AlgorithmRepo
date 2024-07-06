import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int kCol = s.charAt(0) - 'A' + 1;
        int kRow = s.charAt(1) - '0';
        s = st.nextToken();
        int rCol = s.charAt(0) - 'A' + 1;
        int rRow = s.charAt(1) - '0';

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            s = br.readLine();
            if (s.equals("R")) {

                if (canMove(kRow, kCol + 1)) {
                    if (kCol + 1 == rCol && kRow == rRow) {
                        if (canMove(rRow, rCol + 1)) {
                            kCol++;
                            rCol++;
                        }
                    } else {
                        kCol++;
                    }
                }

            } else if (s.equals("L")) {

                if (canMove(kRow, kCol - 1)) {
                    if (kCol - 1 == rCol && kRow == rRow) {
                        if (canMove(rRow, rCol - 1)) {
                            kCol--;
                            rCol--;
                        }
                    } else {
                        kCol--;
                    }
                }

            } else if (s.equals("B")) {

                if (canMove(kRow - 1, kCol)) {
                    if (kCol == rCol && kRow - 1 == rRow) {
                        if (canMove(rRow - 1, rCol)) {
                            kRow--;
                            rRow--;
                        }
                    } else {
                        kRow--;
                    }
                }

            } else if (s.equals("T")) {

                if (canMove(kRow + 1, kCol)) {
                    if (kCol == rCol && kRow + 1 == rRow) {
                        if (canMove(rRow + 1, rCol)) {
                            kRow++;
                            rRow++;
                        }
                    } else {
                        kRow++;
                    }
                }

            } else if (s.equals("RT")) {

                if (canMove(kRow + 1, kCol + 1)) {
                    if (kCol + 1 == rCol && kRow + 1 == rRow) {
                        if (canMove(rRow + 1, rCol + 1)) {
                            kRow++; kCol++;
                            rRow++; rCol++;
                        }
                    } else {
                        kRow++; kCol++;
                    }
                }

            } else if (s.equals("LT")) {

                if (canMove(kRow + 1, kCol - 1)) {
                    if (kCol - 1 == rCol && kRow + 1 == rRow) {
                        if (canMove(rRow + 1, rCol - 1)) {
                            kRow++; kCol--;
                            rRow++; rCol--;
                        }
                    } else {
                        kRow++; kCol--;
                    }
                }

            } else if (s.equals("RB")) {

                if (canMove(kRow - 1, kCol + 1)) {
                    if (kCol + 1 == rCol && kRow - 1 == rRow) {
                        if (canMove(rRow - 1, rCol + 1)) {
                            kRow--; kCol++;
                            rRow--; rCol++;
                        }
                    } else {
                        kRow--; kCol++;
                    }
                }

            } else if (s.equals("LB")) {

                if (canMove(kRow - 1, kCol - 1)) {
                    if (kCol - 1 == rCol && kRow - 1 == rRow) {
                        if (canMove(rRow - 1, rCol - 1)) {
                            kRow--; kCol--;
                            rRow--; rCol--;
                        }
                    } else {
                        kRow--; kCol--;
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) (kCol + 64)).append(kRow).append("\n");
        sb.append((char) (rCol + 64)).append(rRow).append("\n");
        System.out.println(sb);
    }

    static boolean canMove(int row, int col) {
        return row >= 1 && col >= 1 && row <= 8 && col <= 8;
    }
}

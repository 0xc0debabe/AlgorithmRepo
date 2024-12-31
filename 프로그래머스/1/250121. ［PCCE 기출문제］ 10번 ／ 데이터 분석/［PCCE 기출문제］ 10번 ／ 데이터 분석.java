
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] a = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        solution.solution(a, "date", 20300501, "remain");
    }

    public int[][] solution(int[][] datas, String ext, int val_ext, String sort_by) {
        Arrays.sort(datas, (x, y) -> {
            if (ext.equals("code")) {
                return x[0] - y[0];
            } else if (ext.equals("date")) {
                return x[1] - y[1];
            } else if (ext.equals("maximum")) {
                return x[2] - y[2];
            } else {
                return x[3] - y[3];
            }
        });

        int[][] arr = Arrays.stream(datas)
                .filter(x -> {
                    if (ext.equals("code")) {
                        return x[0] <= val_ext;
                    } else if (ext.equals("date")) {
                        return x[1] <= val_ext;
                    } else if (ext.equals("maximum")) {
                        return x[2] <= val_ext;
                    } else {
                        return x[3] <= val_ext;
                    }
                }).toArray(int[][]::new);

        Arrays.sort(arr, (x, y) -> {
            if (sort_by.equals("code")) {
                return x[0] - y[0];
            } else if (sort_by.equals("date")) {
                return x[1] - y[1];
            } else if (sort_by.equals("maximum")) {
                return x[2] - y[2];
            } else {
                return x[3] - y[3];
            }
        });

        return arr;
    }

}

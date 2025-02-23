import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a = {"O00321", "O49qcGPHuRLR5FEfoO00321"};
        String[] solution1 = solution.solution(a);
        for (String s : solution1) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] files) {
        File[] f = new File[files.length];

        for (int j = 0; j < files.length; j++) {
            String file = files[j];
            StringBuilder head = new StringBuilder();

            int tmp = 0;
            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);

                if (Character.isDigit(c)) {
                    tmp = i;
                    break;
                }

                head.append(c);
            }

            StringBuilder number = new StringBuilder();
            int tmp1 = file.length();
            for (int i = tmp; i < file.length(); i++) {
                char c = file.charAt(i);

                if (!Character.isDigit(c)) {
                    tmp1 = i;
                    break;
                }

                number.append(c);
            }

            f[j] = new File(
                    head.toString(),
                    number.toString(),
                    file.substring(tmp1),
                    j
            );
        }

        Arrays.sort(f);
        return File.mapToStr(f);
    }

    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        int idx;

        public File(String head, String number, String tail, int idx) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }

        public static String[] mapToStr(File[] files) {
            String[] ret = new String[files.length];

            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String h = file.head;
                String n = String.valueOf(file.number);
                String t = file.tail;

                ret[i] = h + n + t;
            }

            return ret;
        }

        @Override
        public int compareTo(File o) {
            if (this.head.toLowerCase().compareTo(o.head.toLowerCase()) == 0) {

                int n1 = Integer.parseInt(this.number);
                int n2 = Integer.parseInt(o.number);

                if (n1 == n2) {
                    return this.idx - o.idx;
                }
                return n1 - n2;
            }

            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
}


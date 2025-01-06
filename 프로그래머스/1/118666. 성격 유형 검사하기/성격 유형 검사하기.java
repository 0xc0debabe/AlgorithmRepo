class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] asdf = {"RT", "RT", "RT"};
        int[] s = {7, 2, 4};
        System.out.println(sol.solution(asdf, s));
    }

    public String solution(String[] surveys, int[] choices) {
        Kakao[] kakaos = new Kakao[8];
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (int i = 0; i < types.length; i++) {
            kakaos[i] = new Kakao(types[i], 0);
        }

        for (int i = 0; i < choices.length; i++) {
            String survey = surveys[i];
            char type1 = survey.charAt(0);
            char type2 = survey.charAt(1);

            int choice = choices[i];
            if (choice < 4) {
                addScore(type1, kakaos, 4 - choice);
            } else if (choice > 4) {
                addScore(type2, kakaos, choice - 4);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i += 2) {
            sb.append(maxType(kakaos[i], kakaos[i + 1]));
        }

        return sb.toString();
    }

    private void addScore(char type, Kakao[] kakaos, int choice) {
        for (Kakao kakao: kakaos) {
            if (kakao.type == type) {
                kakao.score += choice;
                break;
            }
        }
    }

    private char maxType(Kakao kakao1, Kakao kakao2) {
        if (kakao1.score > kakao2.score) {
            return kakao1.type;
        } else if (kakao1.score < kakao2.score) {
            return kakao2.type;
        } else {
            return kakao1.type > kakao2.type ? kakao2.type : kakao1.type;
        }
    }

    static class Kakao {
        char type;
        int score;

        public Kakao(char type, int score) {
            this.type = type;
            this.score = score;
        }
    }

}

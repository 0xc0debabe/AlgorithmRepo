
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(sol.solution(num, "right"));
    }
//    LRLLLRLLRRL
    public String solution(int[] numbers, String hand) {
        char[][] keypad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };

        StringBuilder answer = new StringBuilder();
        char left = '*';
        char right = '#';
        for (int number : numbers) {
            char num = (char) (number + '0');
            if (number % 3 == 1) {
                answer.append('L');
                left = num;
            } else if (number % 3 == 0 && number != 0) {
                answer.append('R');
                right = num;
            } else {
                int leftPos = closeHand(left, num, keypad);
                int rightPos = closeHand(right, num, keypad);

                if (leftPos > rightPos) {
                    answer.append('R');
                    right = num;
                } else if (leftPos < rightPos) {
                    answer.append('L');
                    left = num;
                } else {
                    if (hand.equals("left")) {
                        answer.append('L');
                        left = num;
                    } else {
                        answer.append('R');
                        right = num;
                    }
                }
            }
        }

        return answer.toString();
    }

    private int closeHand(char currNum, char target, char[][] keypad) {
        int[] currPos = getPos(currNum, keypad);
        int[] targetPos = getPos(target, keypad);
        return Math.abs(currPos[0] - targetPos[0]) + Math.abs(currPos[1] - targetPos[1]);
    }

    private int[] getPos(char target, char[][] keypad) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }


}

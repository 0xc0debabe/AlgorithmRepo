import java.math.BigInteger;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] a = {
        };
        Solution solution = new Solution();
        String[] solution1 = solution.solution(a);
        for (String s : solution1) {
            System.out.println(s);
        }

        System.out.println("========================");
//        String[] solution2 = solution.solution1(a);
//        for (String s : solution2) {
//            System.out.println(s);
//        }

    }

    public String[] solution(String[] expressions) {
        int maxDigit = 0;
        int radix = -1;

        for (String expression : expressions) {
            String[] split = expression.split(" ");
            String num1 = split[0];
            String num2 = split[2];
            String sign = split[1];
            String result = split[4];
            maxDigit = findMaxDigit(num1, maxDigit);
            maxDigit = findMaxDigit(num2, maxDigit);

            if (!result.equals("X")) {
                if (isCarryOn(num1, num2, sign, result)) {
                    for (int i = 10; i >= 2; i--) {
                        String value = findValueInRadix(num1, num2, i, sign);
                        if (value.equals(result)) {
                            radix = i;
                            break;
                        }
                    }
                }

                maxDigit = findMaxDigit(result, maxDigit);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String exp : expressions) {
            String[] split = exp.split(" ");
            String num1 = split[0];
            String num2 = split[2];
            String sign = split[1];
            String result = split[4];

            if (!result.equals("X")) continue;

            if (radix == -1) {
                String ret = "?";

                if (maxDigit >= 8) {
                    ret = findValueInRadix(num1, num2, 9, sign);
                } else {
                    int idx1 = num1.length() - 1;
                    int idx2 = num2.length() - 1;
                    boolean flag = true;
                    while (idx1 >= 0 && idx2 >= 0) {
                        char c1 = num1.charAt(idx1);
                        char c2 = num2.charAt(idx2);

                        if (sign.equals("+")) {
                            if ((c1 - '0') + (c2 - '0') > maxDigit) {
                                flag = false;
                                break;
                            }
                        } else {
                            if ((c1 - '0') - (c2 - '0') < 0) {
                                flag = false;
                                break;
                            }
                        }

                        idx1--;
                        idx2--;
                    }

                    if (flag) ret = findValueInRadix(num1, num2, 10, sign);
                }

                String ele = String.format("%s %s %s = %s", num1, sign, num2, ret);
                answer.add(ele);

            } else {
                String ret = findValueInRadix(num1, num2, radix, sign);
                String ele = String.format("%s %s %s = %s", num1, sign, num2, ret);
                answer.add(ele);
            }

        }

        return answer.toArray(String[]::new);
    }

    private String findValueInRadix(String num1, String num2, int radix, String sign) {
        BigInteger n1 = new BigInteger(num1, radix);
        BigInteger n2 = new BigInteger(num2, radix);
        BigInteger result;

        if (sign.equals("+")) {
            result = n1.add(n2);
        } else {
            result = n1.subtract(n2);
        }

        return result.toString(radix);
    }

    private boolean isCarryOn(String n1, String n2, String sign, String result) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int sum;
        if (sign.equals("+")) {
            sum = num1 + num2;
        } else {
            sum = num1 - num2;
        }

        return !String.valueOf(sum).equals(result);
    }

    private int findMaxDigit(String num, int maxDigit) {
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            maxDigit = Math.max(maxDigit, c - '0');
        }
        return maxDigit;
    }

//    public int getMaxDigit(int num) {  // 가장 큰 숫자(digit) 리턴
//        int maxDigit = -1;
//        while (num > 0) {
//            if (num % 10 > maxDigit)
//                maxDigit = num % 10;
//            num /= 10;
//        }
//        return maxDigit;
//    }
//
//    public int convertToDecimalFromBaseN(int num, int base) {  // N진법 -> 10진법
//        int decimal = 0, toMultiply = 1;
//        while (num > 0) {
//            decimal += (num % 10 * toMultiply);
//            toMultiply *= base;
//            num /= 10;
//        }
//        return decimal;
//    }
//
//    public int convertToBaseNFromDecimal(int num, int base) {  // 10진법 -> N진법
//        int baseN = 0, i = 1;
//        while (num > 0) {
//            baseN += (num % base) * i;
//            i *= 10;
//            num /= base;
//        }
//
//        return baseN;
//    }
//
//    public int addTwoNumbersInBaseN(int n1, int n2, int base) {  // N진법 덧셈
//        int sumDecimal = convertToDecimalFromBaseN(n1, base) + convertToDecimalFromBaseN(n2, base);
//        return convertToBaseNFromDecimal(sumDecimal, base);
//    }
//
//    public int subtractTwoNumbersInBaseN(int n1, int n2, int base) {  // N진법 뺄셈
//        int sumDecimal = convertToDecimalFromBaseN(n1, base) - convertToDecimalFromBaseN(n2, base);
//        return convertToBaseNFromDecimal(sumDecimal, base);
//    }
//
//
//    public String[] solution1(String[] expressions) {
//        ArrayList<String> answer = new ArrayList<String>();
//
//        HashSet<Integer> candidates = new HashSet<Integer>(Set.of(2,3,4,5,6,7,8,9));  // 진법 후보
//        int maxDigit = -1;  // 가장 큰 숫자 저장 (후보를 추리기 위함)
//
//        for (String expression: expressions) {
//            String[] splitExpression = expression.split(" ");  // 식을 수와 기호로 분리
//            int n1 = Integer.valueOf(splitExpression[0]);
//            int n2 = Integer.valueOf(splitExpression[2]);
//
//            maxDigit = Math.max(maxDigit, Math.max(getMaxDigit(n1), getMaxDigit(n2)));  // 가장 큰 숫자 저장 (후보 추리기 위함)
//
//            if (!splitExpression[4].equals("X")) {  // 완성된 계산식의 경우에
//                int result = Integer.valueOf(splitExpression[4]);
//
//                maxDigit = Math.max(maxDigit, getMaxDigit(result));
//
//                int base;
//                for (base = 10; base >= 2; base--) {
//                    int n1Dec = convertToDecimalFromBaseN(n1, base);  // n진수 -> 10진수
//                    int n2Dec = convertToDecimalFromBaseN(n2, base);
//                    int calculatedDec, resultDec = convertToDecimalFromBaseN(result, base);  // 2~9진법 계산 수행할 변수 & 명시된 결괏값 10진수 -> 동등성 비교할 예정
//
//                    if (splitExpression[1].equals("+"))
//                        calculatedDec = n1Dec + n2Dec;
//                    else
//                        calculatedDec = n1Dec - n2Dec;
//
//                    if (calculatedDec == resultDec)  // 동등성 비교 (같다면 진법 탐색 종료)
//                        break;
//                }
//
//                if (base != 10) {  // 10이 아닌 값이면 진법을 특정한 것임!
//                    candidates = new HashSet<>(Set.of(base));  // 해당 값으로 대체
//                    break;
//                }
//            }
//        }
//
//
//        if (candidates.size() != 1)  // 진법 확정되지 않은 경우
//            for (int i = 2; i <= maxDigit; i++)  // 후보가 아닌 숫자 제거 -> (등장하는 숫자 중 가장 큰 숫자) + 1 ~ 9 까지를 후보로 남겨놓기 위한 함수 (최소 (등장하는 숫자 중 가장 큰 숫자) + 1 진법이기 때문)
//                candidates.remove(i);
//
//        for (String expression: expressions) {  // 모든 계산식 다시 순회하며 미완성 계산식(A + B = X) 완성
//            String[] splitExpression = expression.split(" ");
//
//            if (!splitExpression[4].equals("X"))
//                continue;
//
//            int n1 = Integer.valueOf(splitExpression[0]);
//            int n2 = Integer.valueOf(splitExpression[2]);
//
//            if (candidates.size() == 1) {  // 진법이 확정된 경우에는 그대로 연산을 수행
//                int base = candidates.iterator().next();
//                answer.add(expression.replace("X", String.valueOf(
//                        splitExpression[1].equals("+") ? addTwoNumbersInBaseN(n1, n2, base) : subtractTwoNumbersInBaseN(n1, n2, base)
//                )));
//                continue;
//            }
//
//            int tmp = -1;
//            boolean cantFind = false;
//            for (int base: candidates) {  // 모든 후보값의 진법으로 계산해보며, 한 번이라도 다른 결과가 나오면 break (X 값을 특정하지 못함)
//                int result = splitExpression[1].equals("+") ? addTwoNumbersInBaseN(n1, n2, base) : subtractTwoNumbersInBaseN(n1, n2, base);
//
//                if (tmp != -1 && result != tmp) {  // 이전 값과 비교하여 다르다면 break
//                    cantFind = true;
//                    break;
//                }
//                tmp = result;
//            }
//
//            if (cantFind)
//                answer.add(expression.replace("X", "?"));
//            else
//                answer.add(expression.replace("X", String.valueOf(tmp)));
//        }
//
//        return answer.toArray(new String[0]);
//    }

}
package java;
import java.util.*;

public class StackCalculateExpression {
    static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    static int[] parseNumber(String s, int ix) {
        int parsed_number = 0;
        while (ix < s.length() && isNumber(s.charAt(ix))) {
            parsed_number *= 10;
            parsed_number += s.charAt(ix++) - '0';
        }
        return new int[]{ix, parsed_number};
    }

    static int[] parseExpression(String s, int ix) {
        int current_sum = 0;
        char sign = '+';

        while (ix < s.length()) {
            char c = s.charAt(ix);
            if (c == '(') {
                int[] result = parseExpression(s, ix + 1);
                ix = result[0];
                current_sum += (sign == '+' ? result[1] : -result[1]);
            } else if (c == ')') {
                return new int[]{ix + 1, current_sum};
            } else if (c == '+' || c == '-') {
                sign = c;
                ix++;
            } else {
                int[] result = parseNumber(s, ix);
                ix = result[0];
                current_sum += (sign == '+' ? result[1] : -result[1]);
            }
        }

        return new int[]{ix, current_sum};
    }

    public static void main(String[] args) {
        String[] testCases = {
            "1+2-3+5",
            "-2+5-3",
            "1+(2-3)+5",
            "2+(3-(4+5))-6",
            "7+(3-1)-(5+2)"
        };

        for (String testCase : testCases) {
            int[] result = parseExpression(testCase, 0);
            System.out.println("Expression: " + testCase + " = " + result[1]);
        }
    }
}


/* 괄호가 없는 경우 지쎔답
public int calculate(String s) {
    int result = 0;
    int sign = 1;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int num = c - '0';
            while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                num = num * 10 + (s.charAt(i + 1) - '0');
                i++;
            }
            result += sign * num;
        } else if (c == '+') {
            sign = 1;
        } else if (c == '-') {
            sign = -1;
        }
    }
    return result;
}

 */



 /* 괄호가 있는 경우 지쎔 답.. 위는 재귀고 이거는 stack쓴 버전
public int calculateWithBrackets(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int sign = 1;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int num = c - '0';
            while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                num = num * 10 + (s.charAt(i + 1) - '0');
                i++;
            }
            result += sign * num;
        } else if (c == '+') {
            sign = 1;
        } else if (c == '-') {
            sign = -1;
        } else if (c == '(') {
            stack.push(result);
            stack.push(sign);
            result = 0;
            sign = 1;
        } else if (c == ')') {
            result *= stack.pop();
            result += stack.pop();
        }
    }
    return result;
}

  */
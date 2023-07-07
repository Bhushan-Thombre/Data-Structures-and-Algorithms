// Conversion of prefix notation to postfix notation and vice-versa using stack.

package prefixToPostfix;

import java.util.Stack;

public class Main {

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static String conversionPreFixToPostFix(String str) {
        int length = str.length();
        Stack<String> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            if (isOperator(str.charAt(i))) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String temp = operand1 + operand2 + str.charAt(i);
                stack.push(temp);
            }else {
                stack.push(String.valueOf(str.charAt(i)));
            }
        }

        return stack.pop();
    }

    public static String conversionPostFixToPreFix(String str) {
        int length = str.length();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (isOperator(str.charAt(i))) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String temp = str.charAt(i) + operand2 + operand1;
                stack.push(temp);
            }else {
                stack.push(String.valueOf(str.charAt(i)));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixNotation = "*-A/BC-/AKL";
        System.out.println("Equivalent postfix notation: " + conversionPreFixToPostFix(prefixNotation));
        String postfixNotation = "ABC/-AK/L-*";
        System.out.println("Equivalent prefix notation: " + conversionPostFixToPreFix(postfixNotation));
    }
}

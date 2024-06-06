package com.khun.dsa.stack;

public class DelimiterMatcher {
    public static boolean isBalanced(String expression) {
        StackX<Character> stackX = new StackX<>(expression.length());

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stackX.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stackX.isEmpty()) {
                    return false;
                }

                char lastOpened = stackX.pop();

                if (!isMatchingPair(lastOpened, ch)) {
                    return false;
                }
            }
        }
        return stackX.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String expression1 = "{[()]}";
        String expression2 = "{[(])}";
        String expression3 = "{{[[(())]]}}";

        System.out.println(expression1 + " is balanced: " + isBalanced(expression1));
        System.out.println(expression2 + " is balanced: " + isBalanced(expression2));
        System.out.println(expression3 + " is balanced: " + isBalanced(expression3));
    }
}

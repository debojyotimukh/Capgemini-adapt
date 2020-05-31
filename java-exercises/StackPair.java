import java.util.*;
/*
hackerrank.com
PracticeJava->Data Structures->Java Stack
Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.
({}[]) #
(({()}))) #
({(){}()})()({(){}()})(){()}    #
{}()))(()()({}}{} #
}}}} #
)))) #
{{{  #
((( #
[]{}(){()}((())){{{}}}{()()}{{}{}} #
[[]][][] #
}{ #

*/

class StackPair {
    /**
     * Checks if two enclosures are pairing or not
     * 
     * @param ch1
     * @param ch2 NOTE: isPair('[',']')==true; isPair(']','[')==false
     * @return
     */
    public static boolean isPair(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')' || ch1 == '{' && ch2 == '}' || ch1 == '[' && ch2 == ']')
            return true;

        return false;
    }

    /**
     * 
     * @param ch
     * @param stack
     */
    public static void findPairInStack(char ch, Stack<Character> stack) {
        if (!stack.isEmpty()) {
            if (isPair(ch, stack.peek()))
                stack.pop();
            else
                stack.push(ch);
        } else
            stack.push(ch);
    }

    /**
     * Given a string, determine if it is balanced or not. Examples of some
     * correctly balanced strings are: "{}()", "[{()}]", "({()})" Examples of some
     * unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
     * 
     * @param str
     * @return
     */
    public static boolean isBalanced(String str) {
        Stack<Character> bracketStack = new Stack<Character>();
        Stack<Character> bracesStack = new Stack<Character>();
        Stack<Character> parenthesisStack = new Stack<Character>();
        char ch;

        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            switch (ch) {
                case ']':
                case '[':
                    findPairInStack(ch, bracketStack);
                    break;

                case '}':
                case '{':
                    findPairInStack(ch, bracesStack);
                    break;

                case '(':
                case ')':
                    findPairInStack(ch, parenthesisStack);
                    break;

                default:
                    break;
            }
        }

        if (bracketStack.isEmpty() && bracesStack.isEmpty() && parenthesisStack.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input) ? "true" : "false");
        }

        sc.close();

    }
}

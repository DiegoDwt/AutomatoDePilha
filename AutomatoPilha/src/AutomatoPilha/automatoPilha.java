package AutomatoPilha;

import java.util.Stack;

public class automatoPilha {

    public static boolean accepts(String input) {
        int currentState = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            switch (currentState) {
                case 0:
                    if (c == 'a' || c == 'b') {
                        stack.push(c);
                    } else if (c == 'X') {
                        currentState = 1;
                    } else {
                        return false;
                    }
                    break;

                case 1:
                    if (c == 'a' && !stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                    } else if (c == 'b' && !stack.isEmpty() && stack.peek() == 'b') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;

                default:
                    return false;
            }
        }

        return stack.isEmpty() && currentState == 1;
    }
    
    public static void main(String[] args) {
        String[] testCases = { "aaXaa", "abXba", "aXa", "bXb", "aXb", "abXaa", "aabXbaa" };

        for (String input : testCases) {
            boolean accepted = accepts(input);
            System.out.println(input + ": " + accepted);
        }
    }
}
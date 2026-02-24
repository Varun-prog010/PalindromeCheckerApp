/**
 MAIN CLASS - UseCase5PalindromeCheckerApp

 Use Case 5: Stack Based Palindrome Checker

 Description:
 This class validates a palindrome using a Stack
 data structure which follows the LIFO principle.

 At this stage, the application:
 - Pushes characters into a stack
 - Pops them in reverse order
 - Compares with original sequence
 - Displays the result

 This maps stack behavior to reversal Logic.

 @author Varun Misra
 @version 5.0
 **/

import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (int i = 0; i < cleaned.length(); i++) {
            stack.push(cleaned.charAt(i));
        }

        // Compare by popping characters
        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) != stack.pop()) {
                return false; // Mismatch found
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        // Hardcoded test string
        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
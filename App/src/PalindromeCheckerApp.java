/** MAIN CLASS - UseCase9PalindromeCheckerApp

 Use Case 9: Recursive Palindrome Checker

 Description:
 This class validates a palindrome using recursion.
 It compares the first and last characters recursively until the base condition is reached.

 Key Concepts:
 - Recursion
 - Base Condition
 - Call Stack
 - Efficient character comparison without extra data structures

 @author Varun Misra
 @version 9.0
 **/

public class PalindromeChecker {

    // Recursive helper method
    private static boolean isPalindromeRecursive(String text, int start, int end) {
        // Base condition: crossed indices or single character
        if (start >= end) return true;

        // Compare characters
        if (text.charAt(start) != text.charAt(end)) return false;

        // Recursive call for next inner substring
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Public method for cleaner interface
    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }

    public static void main(String[] args) {

        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
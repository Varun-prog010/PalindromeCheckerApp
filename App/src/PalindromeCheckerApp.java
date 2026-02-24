/** MAIN CLASS - UseCase10PalindromeCheckerApp

 Use Case 10: Case-Insensitive & Space-Ignored Palindrome Checker

 Description:
 This class validates a palindrome while ignoring spaces and case.
 It preprocesses the string using regular expressions and applies
 recursive logic for palindrome validation.

 Key Concepts:
 - String preprocessing
 - Regular expressions
 - Recursion (or other logic)
 - Case-insensitive comparison
 - Ignoring spaces

 @author Varun Misra
 @version 10.0
 **/

public class PalindromeChecker {

    // Recursive helper method
    private static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;  // Base case
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Public method for cleaner interface
    public static boolean isPalindrome(String text) {
        // Normalize input: remove spaces, convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
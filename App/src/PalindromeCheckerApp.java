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
    }/** MAIN CLASS - UseCase11PalindromeCheckerApp

     Use Case 11: Object-Oriented Palindrome Checker with Encapsulation

     Description:
     Encapsulates the palindrome checking logic within a dedicated class.
     The class exposes a single public method checkPalindrome() for validation.
     This demonstrates encapsulation and the Single Responsibility Principle.

     Key Concepts:
     - Encapsulation (private fields, public methods)
     - Single Responsibility Principle
     - Internal data structures (Stack / Array)
     - Reusable and modular code

     @author Varun Misra
     @version 11.0
     **/

import java.util.Stack;

    public class PalindromeChecker {

        // Private field to store the text
        private String text;

        // Constructor
        public PalindromeChecker(String text) {
            this.text = text;
        }

        // Public method to check palindrome
        public boolean checkPalindrome() {
            if (text == null || text.isEmpty()) return true;

            // Normalize text: remove spaces and convert to lowercase
            String cleaned = text.replaceAll("\\s+", "").toLowerCase();

            // Use internal Stack for LIFO comparison
            Stack<Character> stack = new Stack<>();
            for (char ch : cleaned.toCharArray()) {
                stack.push(ch);
            }

            for (char ch : cleaned.toCharArray()) {
                if (stack.pop() != ch) {
                    return false;
                }
            }
            return true;
        }

        // Optional: getter for the text
        public String getText() {
            return text;
        }

        public static void main(String[] args) {
            String input = "A man a plan a canal Panama";

            PalindromeChecker checker = new PalindromeChecker(input);
            boolean result = checker.checkPalindrome();

            System.out.println("Input text : " + checker.getText());
            System.out.println("Is it Palindrome ? : " + result);
        }
    }
}
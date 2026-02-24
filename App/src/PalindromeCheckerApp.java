/**
 MAIN CLASS - UseCase2PalindromeCheckerApp
 Use Case 2: Hardcoded Palindrome Validation
 Description:
 This class demonstrates basic palindrome validation
 using a hardcoded string value.

 At this stage, the application:
 Stores a predefined string
 Compares characters from both ends
 Determines whether the string is a palindrome
 Displays the result on the console

 This use case introduces fundamental comparison logic
 before using advanced data structures.

 * @author Varun Misra
 * @version 2.0

 **/

public class PalindromeChecker {

    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        // Hardcoded string
        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
/**
 MAIN CLASS - UseCase4PalindromeCheckerApp

 Use Case 4: Character Array Based Validation

 Description:
 This class validates a palindrome by converting
 the string into a character array and comparing
 characters using the two-pointer technique.

 At this stage, the application:
 - Converts string to char array
 - Uses start and end pointers
 - Compares characters efficiently
 - Displays the result

 This reduces extra memory usage.
 @author Varun Misra
 @version 4.0
 **/

import java.util.*;
public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        // Convert to character array
        char[] chars = cleaned.toCharArray();

        // Two-pointer approach
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Hardcoded test string (can change to other test cases)
        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
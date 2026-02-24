/**
 MAIN CLASS - UseCase3PalindromeCheckerUsingReverse

 Use Case 3: Reverse String Based Palindrome Check

 Description:
 This class checks whether a string is a palindrome
 by reversing the string and comparing it with
 the original value.

 At this stage, the application:
 Iterates the string in reverse order
 Builds a reversed version
 Compares original and reversed strings
 Displays the validation result

 This introduces transformation-based validation.

 @author Sourav Kumar
 @version 3.0
 **/

import java.util.*;
public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        // Reverse the string using a loop
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i); // Concatenate characters
        }

        // Compare original cleaned string with reversed string
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {

        // Hardcoded test string (can be changed)
        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
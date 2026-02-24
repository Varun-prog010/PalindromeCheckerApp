/** MAIN CLASS - UseCase7PalindromeCheckerApp

 Use Case 7: Deque Based Optimized Palindrome Checker

 Description:
 This class validates a palindrome using a Deque
 (Double Ended Queue).
 Characters are inserted into the deque and then compared by removing elements from both ends:
 - removeFirst()
 - removeLast()

 This avoids reversing the string and provides an efficient front-to-back comparison approach.

 This use case demonstrates optimal bidirectional traversal using Deque.
 @author Varun Misra
 @version 7.0
 **/

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeChecker {

    public static boolean isPalindrome(String text) {

        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        // Use Deque to store characters
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch); // Insert at the rear
        }

        // Compare front and rear elements until deque is empty or mismatch found
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false; // Mismatch found
            }
        }

        return true; // All matched
    }

    public static void main(String[] args) {

        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
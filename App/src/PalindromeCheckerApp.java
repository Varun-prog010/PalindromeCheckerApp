import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeChecker {

    public static boolean isPalindrome(String text) {

        // Remove spaces and convert to lowercase
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into BOTH data structures
        for (int i = 0; i < cleaned.length(); i++) {
            char ch = cleaned.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO
        }

        // Compare dequeue (FIFO) vs pop (LIFO)
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
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
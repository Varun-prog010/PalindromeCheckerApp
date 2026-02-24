/** MAIN CLASS - UseCase12PalindromeCheckerApp

 Use Case 12: Strategy Pattern for Palindrome Algorithms (Advanced)

 Description:
 This version uses the Strategy Pattern to allow dynamic selection of
 palindrome checking algorithms at runtime.
 Different strategies (Stack, Deque, Recursive) can be injected.

 Key Concepts:
 - Strategy Pattern
 - Interface-based polymorphism
 - Encapsulation of algorithm behavior
 - Dynamic algorithm selection

 @author Varun Misra
 @version 12.0
 **/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Strategy interface
interface PalindromeStrategy {
    boolean check(String text);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : cleaned.toCharArray()) stack.push(ch);
        for (char ch : cleaned.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : cleaned.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Recursive implementation
class RecursiveStrategy implements PalindromeStrategy {

    private boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    @Override
    public boolean check(String text) {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }
}

// Context class
class PalindromeCheckerClass {
    private PalindromeStrategy strategy;

    public PalindromeCheckerClass(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.check(text);
    }
}

// Demo
public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Choose strategy dynamically
        PalindromeCheckerClass checker = new PalindromeCheckerClass(new StackStrategy());
        System.out.println("Using StackStrategy: " + checker.checkPalindrome(input));

        checker.setStrategy(new DequeStrategy());
        System.out.println("Using DequeStrategy: " + checker.checkPalindrome(input));

        checker.setStrategy(new RecursiveStrategy());
        System.out.println("Using RecursiveStrategy: " + checker.checkPalindrome(input));
    }
}
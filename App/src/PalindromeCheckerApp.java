/** MAIN CLASS - UseCase8PalindromeCheckerApp

 Use Case 8: Linked List Based Palindrome Checker

 Description:
 This class checks whether a string is a palindrome
 using a LinkedList.

 Characters are added to the list and then compared
 by removing elements from both ends:

 - removeFirst()
 - removeLast()

 This demonstrates how LinkedList supports
 double-ended operations for symmetric validation.

 @author Varun Misra
 @version 8.0
 **/

public class PalindromeChecker {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert string to linked list
    private static Node stringToLinkedList(String text) {
        Node head = null, tail = null;
        for (char ch : text.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Reverse a linked list starting from given node
    private static Node reverseList(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Check if linked list is palindrome
    public static boolean isPalindrome(String text) {

        // Clean the input
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        // Edge cases: empty or single character
        if (cleaned.length() <= 1) return true;

        // Convert to linked list
        Node head = stringToLinkedList(cleaned);

        // Use fast and slow pointers to find the middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        Node secondHalf = reverseList(slow.next);

        // Compare first and second halves
        Node p1 = head;
        Node p2 = secondHalf;
        boolean palindrome = true;
        while (p2 != null) {
            if (p1.data != p2.data) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list (optional)
        slow.next = reverseList(secondHalf);

        return palindrome;
    }

    public static void main(String[] args) {

        String input = "Madam";

        boolean result = isPalindrome(input);

        System.out.println("Input text : " + input);
        System.out.println("Is it Palindrome ? : " + result);
    }
}
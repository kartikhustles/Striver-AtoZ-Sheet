import java.util.ArrayList;
import java.util.Collections;

public class PalindromeLinkedList {
    // Approach 1
    public boolean isPalindrome(ListNode temp) {
        ListNode head = temp;
        ArrayList<Integer> a = new ArrayList<>();

        while (head != null) {
            a.add(head.val);
            head = head.next;
        }

        ArrayList<Integer> b = new ArrayList<>();
        b.addAll(a);
        Collections.reverse(a);

        if (a.equals(b))
            return true;
        return false;

    }

    // Approach 2
    public ListNode findMid(ListNode head) {
        // Slow Fast Concept

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my midNode
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next != null) {
            return true;
        }

        // step 1 - find mid
        ListNode midNode = findMid(head);

        // step 2 - reverse 2nd half
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev; // right half head
        ListNode left = head;

        // step 3 - check left half & right half
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
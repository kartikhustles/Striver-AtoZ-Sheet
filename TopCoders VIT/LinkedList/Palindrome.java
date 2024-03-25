import java.util.Scanner;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node1 = new Node(-1);

        int val;

        Node temp1 = node1;
        while ((val = sc.nextInt()) != -1) {
            Node newNode = new Node(val);
            temp1.next = newNode;
            temp1 = temp1.next;
        }
        node1 = node1.next;

        boolean ans = checkPalindrome(node1);

        System.out.println(ans);
    }

    static boolean checkPalindrome(Node head) {
        if (head == null || head.next != null) {
            return true;
        }

        Node mid = getMid(head);

        // reverse
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    static Node getMid(Node l1) {
        Node slow = l1;
        Node fast = l1;

        while (fast.next != null || fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
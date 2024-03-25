import java.util.*;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class OddEven {
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node oddHead = head;
        Node evenHead = head.next;
        Node odd = oddHead;
        Node even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node dummy = new Node(-1);
        Node current = dummy;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            current.next = new Node(val);
            current = current.next;
        }

        Node reorderedList = oddEvenList(dummy.next);

        while (reorderedList != null) {
            System.out.print(reorderedList.val + " -> ");
            reorderedList = reorderedList.next;
        }
        System.out.print("NULL");
    }
}
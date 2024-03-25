import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}

public class ReverseKElements {
    public static Node reverse(Node head, int k) {
        if (head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        // reverse
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // next reverse
        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }

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

        Node ans = reverse(node1, val);

        while (ans != null) {
            System.out.print(ans.data + " -> ");
            ans = ans.next;
        }
        System.out.print("NULL");
    }
}

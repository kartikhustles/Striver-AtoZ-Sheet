import java.util.*;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class RotateList {
    public static Node rotateRight(Node head, int k) {
        // base case
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        // calculating size
        int size = 1;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        // if k value is greater than size
        k = k % size;
        if (k == size || k == 0) {
            return head;
        }

        // hero logic
        int i = 1;
        temp = head;
        Node next = head.next;
        while (i != (size - k)) {
            temp = temp.next;
            next = next.next;
            i++;
        }
        temp.next = null;
        temp = head;
        head = next;
        while (next.next != null) {
            next = next.next;
        }
        next.next = temp;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node1 = new Node(-1);

        int val;
        int k = sc.nextInt();

        Node temp1 = node1;
        while ((val = sc.nextInt()) != -1) {
            Node newNode = new Node(val);
            temp1.next = newNode;
            temp1 = temp1.next;
        }
        node1 = node1.next;

        Node ans = rotateRight(node1, k);

        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.print("NULL");
    }
}

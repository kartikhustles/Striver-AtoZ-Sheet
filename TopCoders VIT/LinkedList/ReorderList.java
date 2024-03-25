import java.util.*;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class ReorderList {
    // Revesing the Second Half
    public static Node reverse(Node head) {
        if (head == null)
            return null;
        Node prev = null;
        Node curr = head;
        Node nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    // adding the LinkedList In alternate manner
    public static void merge(Node list1, Node list2) {
        while (list2 != null) {
            Node nextNode = list1.next;
            list1.next = list2;
            list1 = list2;
            list2 = nextNode;
        }
    }

    public static Node reorderList(Node head) {
        if (head == null || head.next == null)
            return head;
        // Dividing the LinkedList
        Node slow = head;
        Node fast = head;
        Node prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        Node list1 = head;
        Node list2 = reverse(slow);
        merge(list1, list2);

        return head;
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

        Node ans = reorderList(node1);

        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.print("NULL");
    }
}
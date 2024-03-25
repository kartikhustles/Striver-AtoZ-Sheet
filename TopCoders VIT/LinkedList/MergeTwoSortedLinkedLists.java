import java.util.*;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedLinkedLists {
    static Node sortedMerge(Node l1, Node l2) {
        Node prehead = new Node(-1);
        Node cur = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node1 = new Node(-1);

        Node node2 = new Node(-1);

        int val;

        Node temp1 = node1;
        while ((val = sc.nextInt()) != -1) {
            Node newNode = new Node(val);
            temp1.next = newNode;
            temp1 = temp1.next;
        }
        node1 = node1.next;

        Node temp2 = node2;
        while ((val = sc.nextInt()) != -1) {
            Node newNode = new Node(val);
            temp2.next = newNode;
            temp2 = temp2.next;
        }
        node2 = node2.next;

        Node ans = sortedMerge(node1, node2);

        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.print("NULL");
    }
}
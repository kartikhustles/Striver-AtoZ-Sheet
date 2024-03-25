import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class MergeKArray {
    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (Node list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        Node dummy = new Node(-1);
        Node current = dummy;

        while (!minHeap.isEmpty()) {
            Node smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        Node[] lists = new Node[k];
        for (int i = 0; i < k; i++) {
            Node head = new Node(-1);
            Node current = head;
            int val;
            while ((val = scanner.nextInt()) != -1) {
                current.next = new Node(val);
                current = current.next;
            }
            lists[i] = head.next;
        }

        Node mergedList = mergeKLists(lists);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
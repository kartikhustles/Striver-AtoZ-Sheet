public class RemoveNthFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null) {
                return null;
            }
            int size = 0, target;
            ListNode temp = head;
            ListNode targetNode = head;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            if (size == n) {
                head = head.next;
                return head;
            }
            temp = head;

            System.out.println(size);
            target = size - n - 1;
            while (target != 0) {
                temp = temp.next;
                target--;
            }
            targetNode = temp.next;
            temp.next = targetNode.next;
            targetNode.next = null;

            return head;
        }
    }
}

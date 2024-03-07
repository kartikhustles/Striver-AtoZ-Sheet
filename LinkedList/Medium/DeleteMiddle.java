public class DeleteMiddle {
    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            int size = 0;
            ListNode temp = head, targetNode;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            temp = head;
            size = (size / 2) - 1;
            while (size != 0) {
                temp = temp.next;
                size--;
            }
            targetNode = temp.next;
            temp.next = targetNode.next;
            targetNode.next = null;

            return head;
        }
    }
}

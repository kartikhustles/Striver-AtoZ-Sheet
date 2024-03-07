public class OddEvenList {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }
            ListNode first = head;
            ListNode second = first.next;
            ListNode secondhalf = second;
            while (first.next != null && second.next != null && second.next.next != null) {
                first.next = second.next;
                second.next = first.next;
            }
            first.next = secondhalf;
            secondhalf.next = null;

            return head;
        }
    }
}

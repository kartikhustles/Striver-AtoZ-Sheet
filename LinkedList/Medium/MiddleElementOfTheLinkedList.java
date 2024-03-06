class MiddleElementOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        int count = 1, target;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        target = count / 2;
        temp = head;
        while (target != 0) {
            temp = temp.next;
            target--;
        }

        head = temp;

        return head;
    }
}
import java.util.ArrayList;

public class GetIntersectionNode {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            ListNode temp = headA, temp2;

            while (temp != null) {
                A.add(temp.val);
                temp = temp.next;
            }

            temp = headB;

            while (temp != null) {
                B.add(temp.val);
                temp = temp.next;
            }

            int sizeA = A.size(), sizeB = B.size(), common = 0, i = 0, target;

            while (A.get(sizeA - i - 1) == B.get(sizeB - i - 1)) {
                common++;
                i++;
            }

            target = sizeA - common;

            temp = headA;
            while (target != 0) {
                temp = temp.next;
                target--;
            }

            target = sizeA - common;
            temp2 = headB;

            while (target != 0) {
                temp2 = temp2.next;
                target--;
            }

            temp.next = temp2.next;

            return headA;

        }
    }
}

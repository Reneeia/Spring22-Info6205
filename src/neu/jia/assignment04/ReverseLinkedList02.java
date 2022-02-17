package neu.jia.assignment04;

public class ReverseLinkedList02 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // find the prev, where prev.next is leftNode
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // where cur Node is the leftNode
        ListNode cur = prev.next;

        // find the RightNode and record this oldRightNode
        ListNode oldRight = cur;
        int count = 0;
        while (count < right - left) {
            oldRight = oldRight.next;
            count++;
        }

        // recode the rightNext, to connected later, after the reverse in post processing step
        ListNode rightNext = oldRight.next;
        // cut the list so we can call existing reverseList
        oldRight.next = null;


        ListNode newRight = cur;
        ListNode newLeft = reverseList(cur);


        // post processing, connect back
        prev.next = newLeft;
        newRight.next = rightNext;

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

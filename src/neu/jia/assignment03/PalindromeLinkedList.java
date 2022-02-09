package neu.jia.assignment03;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode front = head;
        ListNode back = head;

        while (front != null && front.next != null) {
            front = front.next.next;
            back = back.next;
        }

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverseLinkedList(back);

        while (firstHalfHead != null && secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

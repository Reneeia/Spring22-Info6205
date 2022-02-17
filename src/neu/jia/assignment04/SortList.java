package neu.jia.assignment04;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //3 pointers, temp is the tail of the firstHalf,
        // slow is the start of secondHalf,
        //fast is the tail of the secondHalf

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //break the list into firstHalf and secondHalf
        temp.next = null;

        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(slow);

        return merge(firstHalf, secondHalf);
    }

    //helper method to merge the firstHalf and secondHalf by ascending order
    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val < secondHalf.val) {
                cur.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                cur.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            cur = cur.next;
        }

        if (firstHalf != null) {
            cur.next = firstHalf;
            firstHalf = firstHalf.next;
        } else {
            cur.next = secondHalf;
            secondHalf = secondHalf.next;
        }
        return dummy.next;
    }
}

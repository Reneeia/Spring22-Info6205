package neu.jia.assignment04;

public class MaximumTwinSumOfALinkedList {

    public int pairSum(ListNode head) {
        //solution without converting to array

        //break a linked list in the middle by two pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //break the first half list
        prev.next = null;

        ListNode secondHalf = reverseList(slow);

        return compareSum(head, secondHalf);
    }

    //helper method to reverse the list
    private ListNode reverseList(ListNode head) {
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

    //helper method to compare pari sums, return the maximum
    private int compareSum(ListNode firstHalf, ListNode secondHalf) {
        int sum = Integer.MIN_VALUE;
        ListNode cur1 = firstHalf;
        ListNode cur2 = secondHalf;
        while (cur1 != null && cur2 != null) {
            sum = Math.max(sum, cur1.val + cur2.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return sum;
    }
}

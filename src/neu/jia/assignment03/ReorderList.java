package neu.jia.assignment03;

public class ReorderList {

    //try to solve the problem in 3 steps:
    //1.separate the LinkedList into 2 lists
    //2.reverse the second half
    //3.merge the two lists together

    public void reorderList(ListNode head) {
        //edge cases list is null, or list only has one node (no need to reorder
        if (head == null || head.next == null) {
            return;
        }

        //one null prev node, two pointers,
        ListNode firstHalf = head;
        ListNode back = head;
        ListNode front = head;
        ListNode prev = null;

        while (front != null && front.next != null) {
            prev = back;
            back = back.next;
            front = front.next.next;
        }
        //break the first half tail
        prev.next = null;

        ListNode secondHalf = reverseLinkedList(back);

        head = merge(firstHalf, secondHalf);

    }

    //method to reverse the linked ist
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

    //method to merge two linked lists
    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (firstHalf != null && secondHalf != null) {

            cur.next = firstHalf;
            firstHalf = firstHalf.next;

            cur.next.next = secondHalf;
            secondHalf = secondHalf.next;

            cur = cur.next.next;
        }

        if (firstHalf != null) {
            cur.next = firstHalf;
        } else {
            cur.next = secondHalf;
        }
        return dummy.next;
    }
}

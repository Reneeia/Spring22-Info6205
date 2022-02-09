package neu.jia.assignment03;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //create a ListNode .next = head to store the real head
        ListNode prev = new ListNode(0);
        prev.next = head;

        //two pointers
        ListNode front = prev;
        ListNode back = prev;

        //to move n step for front pointer
        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        //move front back pointers together,
        // and now the distance between front and back is n
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        //back.next is the ListNode should be removed
        back.next = back.next.next;
        return prev.next;
    }
}
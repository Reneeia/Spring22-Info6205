package neu.jia.assignment03;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //two pointers: odd start from head, even from head.next
        ListNode odd = head;
        ListNode even = head.next;

        //store the node even head
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = odd.next;
        }
        //merge odd half to evenHead
        odd.next = evenHead;
        return head;
    }
}

package neu.jia.assignment03;

public class RemoveDuplicatesFromSortedList02 {
    public ListNode deleteDuplicates(ListNode head) {
        //prev point at head to store the head, prev.next
        ListNode prev = new ListNode(0);
        prev.next = head;
        //pointer cur to iterate the list
        ListNode cur = prev;

        while (cur.next != null && cur.next.next != null) {
            //check if the cur.next value equals cur.next.next value,
            //if equals(have duplicates), store the duplicate value
            if (cur.next.val == cur.next.next.val) {
                int duplicate = cur.next.val;
                while (cur.next != null && cur.next.val == duplicate) {
                    cur.next = cur.next.next;
                }
                //if there is no duplicate
            } else {
                cur = cur.next;
            }
        }
        //return the head stored before
        return prev.next;
    }
}

package neu.jia.assignment04;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        //create 2 dummy head for 2 new list
        ListNode dummy1 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode cur2 = dummy2;

        while (head != null) {
            // dummy1.next to contain numbers < x, dummy2.next to contain numbers >= x
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                cur1.next = temp;
                cur1 = cur1.next;
            } else {
                cur2.next = temp;
                cur2 = cur2.next;
            }
            //iterate input list
            head = head.next;
        }
        //merge 2 lists
        cur1.next = dummy2.next;

        return dummy1.next;
    }
}

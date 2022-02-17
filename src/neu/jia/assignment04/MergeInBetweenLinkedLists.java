package neu.jia.assignment04;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode head1 = list1;
        ListNode prev1 = null;
        ListNode cur1 = list1;

        //list1 go to a position
        for (int i = 0; i < a; i++) {
            prev1 = cur1;
            cur1 = cur1.next;
        }

        //connect list1(to a position as tail) to the head of list2
        prev1.next = list2;

        //continue to make list1 to b position
        for (int j = 0; j <= b - a; j++) {
            prev1 = cur1;
            cur1 = cur1.next;
        }

        //break list1 from tail
        prev1.next = null;

        ListNode prev2 = null;
        ListNode cur2 = list2;

        //iterate list2
        while (cur2 != null) {
            prev2 = cur2;
            cur2 = cur2.next;
        }

        //connect list2 to the real tail of list1
        prev2.next = cur1;
        return head1;
    }
}

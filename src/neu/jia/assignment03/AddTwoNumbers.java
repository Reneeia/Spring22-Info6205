package neu.jia.assignment03;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            int curVal = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(curVal);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if (carry != 0) {
            if (l1 != null) {
                cur.next = addTwoNumbers(l1, new ListNode(1));
            } else if (l2 != null) {
                cur.next = addTwoNumbers(l2, new ListNode(1));
            } else {
                cur.next = new ListNode(1);
            }
        } else {
            if (l1 != null) {
                cur.next = l1;
            } else if (l2 != null) {
                cur.next = l2;
            }
        }
        return dummy.next;

    }
}
